package com.gmail.klepikovmichael174.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.klepikovmichael174.project1.ui.CitiesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.container, CitiesFragment())
            .commit()
    }
}