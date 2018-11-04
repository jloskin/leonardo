package petproject.loskin.leonardo.presentation.ui

import androidx.fragment.app.Fragment
import petproject.loskin.leonardo.domain.magazine.goods.Filter
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.magazine.goods.GoodsFragment
import petproject.loskin.leonardo.presentation.ui.magazine.subcategories.SubCategoriesFragment
import petproject.loskin.leonardo.presentation.ui.news.news.NewsFragment
import petproject.loskin.leonardo.util.cicerone.SupportAppxScreen

object Screens {
    class SubCategories(title: String, link: String) : SupportAppxScreen() {
        override val fragment: Fragment = SubCategoriesFragment.instance(title, link)
    }

    class NewsScreen : SupportAppxScreen() {
        override val fragment: Fragment = NewsFragment()
    }

    class GoodsScreen : SupportAppxScreen() {
        override val fragment: Fragment = CategoriesFragment()
    }

    class GoodsFragmentScreen(title: String, link: String) : SupportAppxScreen() {
        override val fragment: Fragment = GoodsFragment.instance(title, link)
    }

    class FilterScreen(filters: List<Filter>) : SupportAppxScreen() {
        override val fragment: Fragment = FilterFragment.instance(filters)
    }
}