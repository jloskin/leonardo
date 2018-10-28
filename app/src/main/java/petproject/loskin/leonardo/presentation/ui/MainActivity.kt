package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import petproject.loskin.leonardo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val navController = nav_host_fragment.findNavController()
        setupActionBarWithNavController(navController, drawer_layout)
        nav_view.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean = NavigationUI.navigateUp(drawer_layout, nav_host_fragment.findNavController())
}
