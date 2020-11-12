package com.example.mypizza.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypizza.R
import com.example.mypizza.pizzafav.ui.PizzasViewModel
import com.example.mypizza.pizzarec.RecPizzasViewModel
import com.example.mypizza.ui.adapter.PizzaItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_page.*
import javax.inject.Inject


class MainPage : DaggerFragment() {


    @Inject lateinit var viewModelPizzafav: PizzasViewModel
    @Inject lateinit var viewModelPizzaRec: RecPizzasViewModel

    val pizzaFavAdapter= GroupAdapter<GroupieViewHolder>()
    val pizzaRecAdapter= GroupAdapter<GroupieViewHolder>()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.main_page, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        crearPizza.setOnClickListener{
            findNavController().navigate(R.id.to_create_pizza)
        }

        Reciclerview_favorite.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        Reciclerview_favorite.adapter=pizzaFavAdapter

        Reciclerview_recommended.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false )
        Reciclerview_recommended.adapter=pizzaRecAdapter

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
      super.onActivityCreated(savedInstanceState)

        viewModelPizzafav.getPizzasLivedata().observe(viewLifecycleOwner, Observer { pizzas ->
           pizzaFavAdapter.addAll(
                pizzas.map { PizzaItem(it) {
                    Toast.makeText(requireContext(),"Pizza =$it", Toast.LENGTH_SHORT).show()

                    val action = MainPageDirections.toPizzaSelect(it)
                    findNavController().navigate(action)

                } }
            )
           })
        viewModelPizzaRec.getRecPizzasLivedata().observe(viewLifecycleOwner, Observer { pizzas ->
            pizzaRecAdapter.addAll(
                pizzas.map{PizzaItem(it){
                    Toast.makeText(requireContext(),"Pizza =$it", Toast.LENGTH_SHORT).show()

                    val action = MainPageDirections.toPizzaSelect(it)
                    findNavController().navigate(action)

                } }
            )
        })

    }



}
