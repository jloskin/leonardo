package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.news_screen.*
import petproject.loskin.leonardo.R

class AllNewsFragment : Fragment() {
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