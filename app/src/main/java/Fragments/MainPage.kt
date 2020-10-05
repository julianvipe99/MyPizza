package Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypizza.R
import com.example.mypizza.data.Pizza
import com.example.mypizza.ui.PizzaAdapter
import com.example.mypizza.ui.adapter.PizzaItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.main_page.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainPage : Fragment() {



    lateinit var pizzaAdapter: GroupAdapter<GroupieViewHolder>
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        pizzaAdapter= GroupAdapter()
        pizzaAdapter.addAll(
            getPizzalist.map { PizzaItem(it) }
        )

        Reciclerview_favorite.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        Reciclerview_favorite.adapter=pizzaAdapter

        Reciclerview_recommended.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false )
        Reciclerview_recommended.adapter=pizzaAdapter
    }
    private val getPizzalist:List<Pizza> = listOf(
    Pizza("1","peperoni"),
    Pizza("2","salami"),
    Pizza("3","hawaiana"),
    Pizza("4","carnes"),
    Pizza("5","3 quesos")
)
}
