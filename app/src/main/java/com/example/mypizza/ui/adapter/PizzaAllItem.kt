package com.example.mypizza.ui.adapter

import com.bumptech.glide.Glide
import com.example.domain.model.AllPizza
import com.example.mypizza.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.pizza_list.view.*
import kotlinx.android.synthetic.main.pizza_list_s.view.*

class PizzaAllItem (
    val allPizza: AllPizza,
    val onItemClicked: (pizzaID:Int) -> Unit
                    ): Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            pizza_name_s.text = allPizza.name
            Glide.with(this)
                .load(allPizza.url)
                .into(pizza_image_s)
            pizza_description_s.text = allPizza.desc

            setOnClickListener {
                onItemClicked(allPizza.id)
            }
        }
    }
    override fun getLayout()= R.layout.pizza_list_s
}