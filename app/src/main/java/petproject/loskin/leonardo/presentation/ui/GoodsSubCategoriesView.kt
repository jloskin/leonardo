package petproject.loskin.leonardo.presentation.ui

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.domain.main.ItemMagazine

interface GoodsSubCategoriesView : MvpView {

    fun loadPage(items: List<ItemMagazine>)

}
