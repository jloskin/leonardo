package petproject.loskin.leonardo.features.news.base.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.features.news.articles.ui.ArticlesFragment
import petproject.loskin.leonardo.features.news.competitions.ui.CompetitionsFragment
import petproject.loskin.leonardo.features.news.mclasses.ui.MClassesFragment
import petproject.loskin.leonardo.features.news.news.ui.NewsFragment

class CoreNewsPagerAdapter(
  val context: Context,
  fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {
  override fun getItem(position: Int): Fragment = when (position) {
    1 -> ArticlesFragment()
    2 -> CompetitionsFragment()
    3 -> MClassesFragment()
    else -> NewsFragment()
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