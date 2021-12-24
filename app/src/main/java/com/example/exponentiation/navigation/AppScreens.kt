package com.example.exponentiation.navigation

import com.example.exponentiation.mvpdetails.DetailsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AppScreens : IScreens {
    override fun detailsScreen() = FragmentScreen {
        DetailsFragment.newInstance()
    }
}