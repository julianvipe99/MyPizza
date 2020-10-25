package com.example.mypizza.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.Ingrediente
import com.example.mypizza.Ingredients.IngredientViewModel
import com.example.mypizza.R
import com.example.mypizza.ui.adapter.IngredientItem
import com.example.mypizza.ui.adapter.PizzaAllItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_crear_pizza.*
import javax.inject.Inject


class CrearPizza : DaggerFragment() {


    @Inject lateinit var viewModelIngrediente: IngredientViewModel
    val ingredienteAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.fragment_crear_pizza, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Reciclerview_Ingr.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        Reciclerview_Ingr.adapter=ingredienteAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelIngrediente.getIngredentsLiveData().observe(viewLifecycleOwner, Observer { ingredient ->
            ingredienteAdapter.addAll(
                ingredient.map { IngredientItem(it) }
            )
        })
    }

}