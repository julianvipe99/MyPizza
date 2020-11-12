package com.example.mypizza.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypizza.R
import com.example.mypizza.pizzaall.AllPizzasViewModel
import com.example.mypizza.ui.adapter.PizzaAllItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.search_page.*
import javax.inject.Inject

class Search : DaggerFragment() {


    @Inject lateinit var viewModelPizzaAll: AllPizzasViewModel

    val pizzaAdapter= GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.search_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Reciclerview_all_pizzas.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        Reciclerview_all_pizzas.adapter=pizzaAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main,menu)

        super.onCreateOptionsMenu(menu, inflater)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelPizzaAll.getAllPizzasLivedata().observe(viewLifecycleOwner, Observer { pizzas ->
            pizzaAdapter.addAll(
                pizzas.map { PizzaAllItem(it){
                    Toast.makeText(requireContext(),"Pizza =$it", Toast.LENGTH_SHORT).show()

                    val action = MainPageDirections.toPizzaSelect(it)
                    findNavController().navigate(action)
                } }
            )
        })
    }



}