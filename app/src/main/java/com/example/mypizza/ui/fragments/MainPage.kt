package com.example.mypizza.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypizza.R
import com.example.mypizza.pizza.ui.PizzasViewModel
import com.example.mypizza.ui.adapter.PizzaItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_page.*
import javax.inject.Inject


class MainPage : DaggerFragment() {


    @Inject lateinit var viewModel: PizzasViewModel

    val pizzaAdapter= GroupAdapter<GroupieViewHolder>()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.main_page, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


        Reciclerview_favorite.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        Reciclerview_favorite.adapter=pizzaAdapter

        Reciclerview_recommended.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false )
        Reciclerview_recommended.adapter=pizzaAdapter

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getPizzasLivedata().observe(viewLifecycleOwner, Observer { pizzas ->
            pizzaAdapter.addAll(
                pizzas.map { PizzaItem(it) }
            )
        })
    }



}
