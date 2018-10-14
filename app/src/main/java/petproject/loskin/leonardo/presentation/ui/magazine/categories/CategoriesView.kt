package petproject.loskin.leonardo.presentation.ui.magazine.categories

import petproject.loskin.leonardo.data.entity.magazine.CategoriesData

interface CategoriesView {
    fun loadGoodsCategories(items: List<CategoriesData>)
}
