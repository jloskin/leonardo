package petproject.loskin.leonardo.presentation.ui

import androidx.fragment.app.Fragment
import petproject.loskin.leonardo.data.entity.shop.goods.Filter
import petproject.loskin.leonardo.presentation.ui.news.MainNewsPage
import petproject.loskin.leonardo.presentation.ui.profile.edit.EditFragment
import petproject.loskin.leonardo.presentation.ui.profile.myprofile.MyProfileFragment
import petproject.loskin.leonardo.presentation.ui.profile.ProfileFragment
import petproject.loskin.leonardo.presentation.ui.profile.authorize.AuthorizationFragment
import petproject.loskin.leonardo.presentation.ui.shop.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.shop.cities.FilterCityFragment
import petproject.loskin.leonardo.presentation.ui.shop.filters.FilterFragment
import petproject.loskin.leonardo.presentation.ui.shop.goods.GoodsFragment
import petproject.loskin.leonardo.presentation.ui.shop.subcategories.SubCategoriesFragment
import petproject.loskin.leonardo.util.cicerone.SupportAppxScreen

object Screens {
  class ProfileScreen : SupportAppxScreen() {
    override val fragment: Fragment = ProfileFragment()
  }

  class AuthorizeScreen : SupportAppxScreen() {
    override val fragment: Fragment = AuthorizationFragment()
  }

  class FilterCity : SupportAppxScreen() {
    override val fragment: Fragment = FilterCityFragment()
  }

  class SubCategories(title: String, link: String) : SupportAppxScreen() {
    override val fragment: Fragment = SubCategoriesFragment.instance(title, link)
  }

  class MainNewsScreen : SupportAppxScreen() {
    override val fragment: Fragment = MainNewsPage()
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

  object Profile {
    class MyProfile : SupportAppxScreen() {
      override val fragment: Fragment = MyProfileFragment()
    }

    class Edit : SupportAppxScreen() {
      override val fragment: Fragment = EditFragment()
    }
  }
}