package petproject.loskin.leonardo.features

import petproject.loskin.leonardo.features.news.base.ui.CoreNewsFragment
import petproject.loskin.leonardo.features.profile.ProfileFragment
import petproject.loskin.leonardo.features.profile.authorize.ui.AuthorizationFragment
import petproject.loskin.leonardo.features.profile.cities.ui.FilterCityFragment
import petproject.loskin.leonardo.features.profile.edit.EditFragment
import petproject.loskin.leonardo.features.profile.myprofile.ui.MyProfileFragment
import petproject.loskin.leonardo.features.shop.categories.ui.CategoriesFragment
import petproject.loskin.leonardo.features.shop.goods.features.filters.models.Filter
import petproject.loskin.leonardo.features.shop.goods.features.filters.ui.FilterFragment
import petproject.loskin.leonardo.features.shop.goods.ui.GoodsFragment
import petproject.loskin.leonardo.features.shop.subcategories.ui.SubCategoriesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    class ProfileScreen : SupportAppScreen() {
        override fun getFragment() = ProfileFragment()
    }

    class AuthorizeScreen : SupportAppScreen() {
        override fun getFragment() = AuthorizationFragment()
    }

    class FilterCity : SupportAppScreen() {
        override fun getFragment() = FilterCityFragment()
    }

    class SubCategories(
        private val title: String,
        private val link: String
    ) : SupportAppScreen() {
        override fun getFragment() = SubCategoriesFragment.instance(title, link)
    }

    class MainNewsScreen : SupportAppScreen() {
        override fun getFragment() = CoreNewsFragment()
    }

    class GoodsScreen : SupportAppScreen() {
        override fun getFragment() = CategoriesFragment()
    }

    class GoodsFragmentScreen(private val title: String, private val link: String) : SupportAppScreen() {
        override fun getFragment() = GoodsFragment.instance(title, link)
    }

    class FilterScreen(private val filters: List<Filter>) : SupportAppScreen() {
        override fun getFragment() = FilterFragment.instance(filters)
    }

    object Profile {
        class MyProfile : SupportAppScreen() {
            override fun getFragment() = MyProfileFragment()
        }

        class Edit : SupportAppScreen() {
            override fun getFragment() = EditFragment()
        }
    }
}