package com.example.mypizza.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypizza.data.Pizza
import com.example.mypizza.R
import kotlinx.android.synthetic.main.pizza_list.view.*

class PizzaAdapter (val items: List<Pizza>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val pizza = LayoutInflater.from(parent.context).inflate(R.layout.pizza_list,parent, false)
        return PizzaViewHolder(pizza)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pizza = items[position]
        holder.itemView.apply {
            pizza_name.text=pizza.name
        }
    }

    override fun getItemCount() = items.size


    inner class PizzaViewHolder(view: View): RecyclerView.ViewHolder(view) { }
}