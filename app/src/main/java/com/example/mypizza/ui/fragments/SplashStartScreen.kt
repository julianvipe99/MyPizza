package com.example.mypizza.ui.fragments

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mypizza.R
import kotlinx.android.synthetic.main.splash_start_screen.*

class SplashStartScreen: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.splash_start_screen, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load("https://i.imgur.com/MF4nVcW.gif")
            .into(start_gif)

        timer.start();
    }

    val timer = object: CountDownTimer(3000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}
        override fun onFinish() {
            findNavController().navigate(R.id.toLogin)
        }
    }

}