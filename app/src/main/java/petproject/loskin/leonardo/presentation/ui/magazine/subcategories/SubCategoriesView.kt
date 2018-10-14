package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import petproject.loskin.leonardo.data.entity.magazine.SubCategoriesData

interface SubCategoriesView {
    fun loadPage(items: List<SubCategoriesData>)
}
