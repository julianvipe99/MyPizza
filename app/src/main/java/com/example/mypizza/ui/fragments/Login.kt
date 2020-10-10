package com.example.mypizza.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mypizza.R
import kotlinx.android.synthetic.main.login.*

class Login : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login.setOnClickListener {
//            Toast.makeText(this, "Iniciando sesión", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

        }
        linkCreate.setOnClickListener {
            findNavController().navigate(R.id.to_create_account)
        }
    }
}