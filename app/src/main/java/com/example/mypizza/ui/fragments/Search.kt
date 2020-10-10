package com.example.mypizza.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypizza.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.main_page.*

class Search:Fragment() {

    val pizzaAdapter= GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.search_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main,menu)

        super.onCreateOptionsMenu(menu, inflater)

        Reciclerview_favorite.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        Reciclerview_favorite.adapter=pizzaAdapter
    }



}