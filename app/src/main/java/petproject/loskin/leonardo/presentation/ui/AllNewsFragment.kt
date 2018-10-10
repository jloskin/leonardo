package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatFragment
import kotlinx.android.synthetic.main.news_screen.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.magazine.NewsComponentHandler

class AllNewsFragment : MvpAppCompatFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomBar?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_news -> null
                R.id.action_competitions -> null
                R.id.action_mclasses -> null
                R.id.action_articles -> null
                else -> null
            }?.let {
                true
            } ?: false
        }
    }
}