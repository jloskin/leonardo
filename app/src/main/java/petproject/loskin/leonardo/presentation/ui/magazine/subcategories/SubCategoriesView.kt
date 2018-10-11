package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.domain.main.SubCategoriesData

interface SubCategoriesView : MvpView {
    fun loadPage(items: List<SubCategoriesData>)
}
