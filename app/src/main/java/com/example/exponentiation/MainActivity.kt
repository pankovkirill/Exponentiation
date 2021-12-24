package com.example.exponentiation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, R.id.main_activity_content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        App.instance.router.navigateTo(App.instance.screens.detailsScreen())
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }
}