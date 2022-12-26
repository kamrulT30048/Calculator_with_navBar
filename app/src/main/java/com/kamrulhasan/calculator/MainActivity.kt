package com.kamrulhasan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btm_nav_bar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_item_numeric ->  {
                    changeLayout(NumericFragment())
//                    title = "Numeric"
                    true
                }
                R.id.menu_item_age ->{
                    changeLayout(AgeFragment())
//                    title = "Age"
                    true
                }
                else -> {
                    changeLayout(TemperatureFragment())
//                    title = "Temperature"
                    true
                }
            }
        }
    }
    private fun changeLayout(fragment: Fragment){
        val fragmentNav = supportFragmentManager.beginTransaction()
        fragmentNav.replace(R.id.nav_host_container, fragment)
        fragmentNav.commit()
    }
}