package petproject.loskin.leonardo.presentation.ui.magazine

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.domain.main.GoodsCategories

interface GoodsCategoriesView : MvpView {
    fun loadGoodsCategories(items: List<GoodsCategories>)
}
