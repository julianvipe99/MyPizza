package com.example.mypizza.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.mypizza.R


class CrearPizza : Fragment() {

    lateinit var rg_masa : RadioGroup
    lateinit var rb_gruesa : RadioButton
    lateinit var rb_delgada : RadioButton

    lateinit var cb_queso : CheckBox
    lateinit var cb_jamon : CheckBox
    lateinit var cb_champiñones : CheckBox
    lateinit var cb_salchicha : CheckBox
    lateinit var cb_pimenton : CheckBox
    lateinit var cb_atun : CheckBox
    lateinit var cb_aceitunas : CheckBox
    lateinit var cb_pepperoni : CheckBox
    lateinit var cb_pollo : CheckBox
    lateinit var cb_bacon : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}