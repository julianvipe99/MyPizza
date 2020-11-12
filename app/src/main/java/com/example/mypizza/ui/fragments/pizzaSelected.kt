package com.example.mypizza.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.domain.model.AllPizza
import com.example.mypizza.R
import com.example.mypizza.pizzaall.AllPizzasViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.pizza_selected.*
import javax.inject.Inject

class pizzaSelected :DaggerFragment() {

    @Inject
    lateinit var viewModelPizza: AllPizzasViewModel
    lateinit var allPizza: AllPizza

    val args: pizzaSelectedArgs by navArgs()
    var price=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.pizza_selected, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sizeSelected()

        order.setOnClickListener{

            if (price>0) {
                val action = pizzaSelectedDirections.toPay(price)
                findNavController().navigate(action)
            }
            else{
                Toast.makeText(requireContext(),"Por favor seleccione un tamanho para al pizza.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelPizza.getAllPizzasLivedata().observe(viewLifecycleOwner, Observer { pizzas ->

            var pizzaId=args.pizzaid

            for (i in pizzas ){
                if(i.id.equals(pizzaId)){
                    allPizza=i;
                    Glide.with(this)
                        .load(i.url)
                        .into(pizza_image)
                }
            }
        })
    }

    fun sizeSelected(){

        small.setOnClickListener{
            price=allPizza.sSmall
            price_t.text="Total: $"+price.toString()

            small.setBackgroundResource(R.drawable.circle_red_button)
            small.setTextColor(Color.WHITE)
            medium.setBackgroundResource(R.drawable.circle_button)
            medium.setTextColor(Color.BLACK)
            large.setBackgroundResource(R.drawable.circle_button)
            large.setTextColor(Color.BLACK)
        }

        medium.setOnClickListener{
            price=allPizza.sMedium
            price_t.text="Total: $"+price.toString()

            medium.setBackgroundResource(R.drawable.circle_red_button)
            medium.setTextColor(Color.WHITE)
            small.setBackgroundResource(R.drawable.circle_button)
            small.setTextColor(Color.BLACK)
            large.setBackgroundResource(R.drawable.circle_button)
            large.setTextColor(Color.BLACK)
        }

        large.setOnClickListener{
            price=allPizza.sLarge
            price_t.text="Total: $"+price.toString()

            large.setBackgroundResource(R.drawable.circle_red_button)
            large.setTextColor(Color.WHITE)
            small.setBackgroundResource(R.drawable.circle_button)
            small.setTextColor(Color.BLACK)
            medium.setBackgroundResource(R.drawable.circle_button)
            medium.setTextColor(Color.BLACK)
        }

    }
}