package com.example.dachuang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dachuang.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = LoginFragment()
        fragmentTransaction.add(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }
}