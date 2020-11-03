package com.example.mypizza.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mypizza.R
import com.example.mypizza.pizzafav.ui.PizzasViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.pizza_selected.*
import javax.inject.Inject

class pizzaSelected :DaggerFragment() {

    @Inject
    lateinit var viewModelPizza: PizzasViewModel

   val args: pizzaSelectedArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.pizza_selected, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelPizza.getPizzasLivedata().observe(viewLifecycleOwner, Observer { pizzas ->

            var pizzaId=args.pizzaid

            for (i in pizzas ){
                if(i.id.equals(pizzaId)){
                    Glide.with(this)
                        .load(i.url)
                        .into(pizza_image)
                }
            }
        })

    }


}