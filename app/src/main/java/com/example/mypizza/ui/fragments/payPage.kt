package com.example.mypizza.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mypizza.R
import kotlinx.android.synthetic.main.end_order.*

class payPage:Fragment() {


    val args: payPageArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.end_order, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        total.text="Total: $"+args.pizzaValue

        order.setOnClickListener{
            findNavController().navigate(R.id.splash_pay)
        }
        mapButton.setOnClickListener{
            findNavController().navigate(R.id.to_map)
        }
    }

}