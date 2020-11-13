package com.example.mypizza.ui.adapter

import com.example.domain.model.Ingrediente
import com.example.mypizza.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.ingredients_list.view.*


class IngredientItem(
    val ingrediente: Ingrediente
):Item() {

    var isSelectedI: Boolean= false

    override fun bind(viewHolder: GroupieViewHolder, position:Int){
        viewHolder.itemView.apply {
            ingredient_check.text = ingrediente.name
            isSelectedI=ingredient_check.isSelected
        }

    }

    override fun getLayout()= R.layout.ingredients_list
}