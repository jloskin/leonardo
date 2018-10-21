package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import petproject.loskin.leonardo.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
                .apply {
                    drawer_layout.addDrawerListener(this)
                    syncState()
                }
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(my_nav_host_fragment)
        setupWithNavController(nav_view, navController)
        nav_view.getHeaderView(0).personLogo.setOnClickListener {
            navController.navigate(R.id.authorizeFragment)
            closeDrawer()
        }

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_goods -> navController.navigate(R.id.categoriesFragment, Bundle(), options)
                else -> {
                }
            }
            closeDrawer()
            true
        }
    }

    override fun onSupportNavigateUp() = findNavController(my_nav_host_fragment).navigateUp()

    override fun onBackPressed() {
        if (closeDrawer()) return
        super.onBackPressed()
    }

    private fun closeDrawer(): Boolean {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
            return true
        }
        return false
    }

    companion object {
        val options = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
    }
}
