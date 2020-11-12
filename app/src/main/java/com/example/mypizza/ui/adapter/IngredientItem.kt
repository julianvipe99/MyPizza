package com.example.mypizza.ui.adapter

import android.widget.CheckBox
import com.example.domain.model.Ingrediente
import com.example.mypizza.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.ingredients_list.view.*

class IngredientItem(
    val ingrediente: Ingrediente
):Item() {

    override fun bind(viewHolder: GroupieViewHolder, position:Int){
        viewHolder.itemView.apply {
            ingredient_check.text = ingrediente.name
        }
    }

    override fun getLayout()= R.layout.ingredients_list
}