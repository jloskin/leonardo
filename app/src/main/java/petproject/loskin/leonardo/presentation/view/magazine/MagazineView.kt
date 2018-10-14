package petproject.loskin.leonardo.presentation.view.magazine

import petproject.loskin.leonardo.data.entity.magazine.GoodsData
import petproject.loskin.leonardo.data.entity.magazine.SubCategoriesData
import petproject.loskin.leonardo.data.entity.magazine.CategoriesData

interface MagazineView {
    fun updateMagazine(items: List<CategoriesData>)

    fun loadPage(items: List<SubCategoriesData>)

    fun loadGoods(items: List<GoodsData>)
}