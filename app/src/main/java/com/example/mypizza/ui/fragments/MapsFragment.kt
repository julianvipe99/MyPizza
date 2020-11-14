package com.example.mypizza.ui.fragments

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.mypizza.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.concurrent.TimeUnit

class MapsFragment : Fragment(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient


    companion object {
        private val LOCATION_PERMISSIONS = arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(gMap: GoogleMap?){
        gMap.let { googleMap = it }
        getLocation()
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        if(isLocationPermissionGranted()){
            fusedLocationProviderClient.requestLocationUpdates(getLocalRequest(), object:
            LocationCallback(){
                override fun onLocationResult(p0: LocationResult?){
                    p0?.let {
                        p0.locations.forEach{
                            moveToUserLocation(LatLng(it.latitude, it.longitude))
                        }
                        fusedLocationProviderClient.removeLocationUpdates(this)
                    } ?: return
                }
            } , Looper.myLooper())
        } else{
            requestPermissions(LOCATION_PERMISSIONS, 999) //obtener resultado
        }
    }

    private fun getLocalRequest(): LocationRequest{
        val locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = TimeUnit.MINUTES.toMillis(1)
        return locationRequest
    }

    private fun isLocationPermissionGranted(): Boolean{
        for (appPermission in LOCATION_PERMISSIONS){
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    appPermission
                ) != PackageManager.PERMISSION_GRANTED
            ){
                return false
            }
        }
        return true
    }

    private fun moveToUserLocation(latLng: LatLng){
        googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12f))
        googleMap?.addMarker(MarkerOptions().position(latLng))
    }
}