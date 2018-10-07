package petproject.loskin.leonardo.presentation.view.magazine

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.data.entity.ItemL
import petproject.loskin.leonardo.domain.main.ItemMagazine
import petproject.loskin.leonardo.domain.main.MagazineItem

interface MagazineView : MvpView {
    fun updateMagazine(items: List<MagazineItem>)

    fun nextPage(items: List<ItemMagazine>)

    fun loadGoods(items: List<ItemL>)
}