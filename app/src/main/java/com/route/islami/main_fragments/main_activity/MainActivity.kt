package com.route.islami.main_fragments.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islami.R
import com.route.islami.main_fragments.AhadethFragment
import com.route.islami.main_fragments.QuranFragment
import com.route.islami.main_fragments.RadioFragment
import com.route.islami.main_fragments.TasbeehFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.quran) {
                pushFragment(QuranFragment())
            } else if (it.itemId == R.id.hadeth) {
                pushFragment(AhadethFragment())
            } else if (it.itemId == R.id.radio) {
                pushFragment(RadioFragment())
            } else if (it.itemId == R.id.sebha) {
                pushFragment(TasbeehFragment())
            }

            return@setOnItemSelectedListener true
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragment, QuranFragment())
            .commit()
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragment, fragment)
            .commit()

    }
}