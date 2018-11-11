package petproject.loskin.leonardo.presentation.ui.news

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.news.articles.ArticlesFragment
import petproject.loskin.leonardo.presentation.ui.news.competitions.fragment.CompetitionsFragment
import petproject.loskin.leonardo.presentation.ui.news.mclasses.MClassesFragment
import petproject.loskin.leonardo.presentation.ui.news.news.NewsFragment

class MainNewsPagerAdapter(
        val context: Context,
        fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            1 -> ArticlesFragment()
            2 -> CompetitionsFragment()
            3 -> MClassesFragment()
            else -> NewsFragment()
        }
    }

    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence {
        val resource = when (position) {
            1 -> R.string.text_articles
            2 -> R.string.text_competitions
            3 -> R.string.text_mclasses
            else -> R.string.news
        }
        return context.getString(resource)
    }

}