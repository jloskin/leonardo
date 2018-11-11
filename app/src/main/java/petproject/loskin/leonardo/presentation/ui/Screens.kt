package petproject.loskin.leonardo.presentation.ui

import androidx.fragment.app.Fragment
import petproject.loskin.leonardo.domain.model.shop.goods.Filter
import petproject.loskin.leonardo.presentation.ui.profile.authorize.AuthorizeFragment
import petproject.loskin.leonardo.presentation.ui.shop.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.shop.filters.FilterFragment
import petproject.loskin.leonardo.presentation.ui.shop.goods.GoodsFragment
import petproject.loskin.leonardo.presentation.ui.shop.subcategories.SubCategoriesFragment
import petproject.loskin.leonardo.presentation.ui.shop.cities.FilterCityFragment
import petproject.loskin.leonardo.presentation.ui.news.news.NewsFragment
import petproject.loskin.leonardo.util.cicerone.SupportAppxScreen

object Screens {
    fun create(fragment: Fragment): SupportAppxScreen = object : SupportAppxScreen() {
        override val fragment: Fragment = fragment
    }

    class AuthorizeScreen : SupportAppxScreen() {
        override val fragment: Fragment = AuthorizeFragment()
    }

    class FilterCity : SupportAppxScreen() {
        override val fragment: Fragment = FilterCityFragment()
    }

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