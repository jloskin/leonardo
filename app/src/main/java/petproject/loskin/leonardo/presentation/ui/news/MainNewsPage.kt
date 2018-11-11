package petproject.loskin.leonardo.presentation.ui.news

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.news_tab.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.base.RootFragment

class MainNewsPage : RootFragment() {
    override fun layoutId(): Int = R.layout.news_tab

    override fun titleId(): Int = R.string.leisure

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = MainNewsPagerAdapter(context!!, childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}