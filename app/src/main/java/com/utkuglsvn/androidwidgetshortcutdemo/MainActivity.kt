package com.utkuglsvn.androidwidgetshortcutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.utkuglsvn.androidwidgetshortcutdemo.databinding.ActivityMainBinding
import com.utkuglsvn.androidwidgetshortcutdemo.widgets.WidgetDemo

// utkuglsvn
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onResume() {
        super.onResume()
        try {
            val action = intent.action
            if (action == WidgetDemo.WIDGET_ACTION && action == "com.utkuglsvn.androidwidgetshortcutdemo.SECOND_FRAGMENT") {
                this.findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.SecondFragment)
            }
            else if(action == "com.utkuglsvn.androidwidgetshortcutdemo.FIRST_FRAGMENT"){

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}