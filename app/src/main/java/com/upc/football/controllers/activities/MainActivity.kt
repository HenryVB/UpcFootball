package com.upc.football.controllers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upc.football.R
import com.upc.football.controllers.fragments.SaveFragment
import com.upc.football.controllers.fragments.TeamFragment

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigateTo(navView.menu.findItem(R.id.menu_home))
    }

    private fun getFragmentFor(item: MenuItem): Fragment {
        return when(item.itemId) {
            R.id.menu_home -> TeamFragment()
            R.id.menu_favourite -> SaveFragment()
            else -> TeamFragment()
        }
    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment, getFragmentFor(item))
            .commit() > 0
    }

}
