package com.example.mypizza.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mypizza.R
import com.example.mypizza.data.Pizza
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.pizza_list.view.*

class PizzaItem(val pizza: Pizza):Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int){
        viewHolder.itemView.apply {
            pizza_name.text=pizza.name
        }

    }

    override fun getLayout()=R.layout.pizza_list
}