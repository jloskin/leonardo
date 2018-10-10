package petproject.loskin.leonardo.presentation.view.magazine

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.data.entity.ItemL
import petproject.loskin.leonardo.domain.main.ItemMagazine
import petproject.loskin.leonardo.domain.main.GoodsCategories

interface MagazineView : MvpView {
    fun updateMagazine(items: List<GoodsCategories>)

    fun loadPage(items: List<ItemMagazine>)

    fun loadGoods(items: List<ItemL>)
}