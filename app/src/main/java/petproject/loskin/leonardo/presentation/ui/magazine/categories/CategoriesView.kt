package petproject.loskin.leonardo.presentation.ui.magazine.categories

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.domain.main.CategoriesData

interface CategoriesView : MvpView {
    fun loadGoodsCategories(items: List<CategoriesData>)
}
