package petproject.loskin.leonardo.presentation.view.magazine

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.data.entity.GoodsData
import petproject.loskin.leonardo.domain.main.SubCategoriesData
import petproject.loskin.leonardo.domain.main.CategoriesData

interface MagazineView : MvpView {
    fun updateMagazine(items: List<CategoriesData>)

    fun loadPage(items: List<SubCategoriesData>)

    fun loadGoods(items: List<GoodsData>)
}