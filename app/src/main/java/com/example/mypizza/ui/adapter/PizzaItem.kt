package com.example.mypizza.ui.adapter

import com.bumptech.glide.Glide
import com.example.domain.model.Pizza
import com.example.mypizza.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.pizza_list.view.*

class PizzaItem(val pizza: Pizza):Item() {



    override fun bind(viewHolder: GroupieViewHolder, position: Int){
        viewHolder.itemView.apply {
            pizza_name.text=pizza.name

            Glide.with(this)
                .load(pizza.url)
                .into(pizza_image)
        }

    }


    override fun getLayout()=R.layout.pizza_list
}