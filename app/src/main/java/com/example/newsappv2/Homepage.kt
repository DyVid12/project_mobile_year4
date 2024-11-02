package com.example.newsappv2

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class Homepage : AppCompatActivity() {
    private lateinit var battomNavigationView: BottomNavigationView
    private lateinit var fragmentlayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

       battomNavigationView = findViewById(R.id.Battom_navbar)
        fragmentlayout = findViewById(R.id.FrameLayout)

        battomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId){
                R.id.headlinesFragment-> loadFragment(HeadlelineFragment(),false)
                R.id.favouritesFragment-> loadFragment(FavouriteFragment(),false)
                R.id.searchFragment -> loadFragment(SearchFragment(),false)
            }
            true


        }
        loadFragment(HeadlelineFragment(), true)
    }
    private fun loadFragment(fragment: Fragment, isAppInitialized: Boolean) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.FrameLayout, fragment)
        } else {
            fragmentTransaction.replace(R.id.FrameLayout, fragment)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}