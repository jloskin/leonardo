package petproject.loskin.leonardo.features.news.base.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.news_tab.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.RootFragment

class CoreNewsFragment : RootFragment() {
  override fun layoutId(): Int = R.layout.news_tab

  override fun titleId(): Int = R.string.leisure

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewPager.adapter = CoreNewsPagerAdapter(context!!, childFragmentManager)
    tabLayout.setupWithViewPager(viewPager)
  }
}