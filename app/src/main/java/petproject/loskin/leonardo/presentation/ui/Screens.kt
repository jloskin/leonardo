package petproject.loskin.leonardo.presentation.ui

import androidx.fragment.app.Fragment
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.magazine.goods.GoodsFragment
import petproject.loskin.leonardo.presentation.ui.magazine.subcategories.SubCategoriesFragment
import petproject.loskin.leonardo.presentation.ui.news.news.NewsFragment
import petproject.loskin.leonardo.util.cicerone.SupportAppxScreen

object Screens {
    class SubCategories(link: String) : SupportAppxScreen() {
        override val fragment: Fragment = SubCategoriesFragment.instance(link)
    }

    class NewsScreen : SupportAppxScreen() {
        override val fragment: Fragment = NewsFragment()
    }

    class GoodsScreen : SupportAppxScreen() {
        override val fragment: Fragment = CategoriesFragment()
    }

    class GoodsFragmentScreen(itemUrl: String) : SupportAppxScreen() {
        override val fragment: Fragment = GoodsFragment.instance(itemUrl)

    }
}