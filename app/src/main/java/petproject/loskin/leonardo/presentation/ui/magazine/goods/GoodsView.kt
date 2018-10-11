package petproject.loskin.leonardo.presentation.ui.magazine.goods

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.data.entity.GoodsData

interface GoodsView : MvpView {
    fun loadGoodsCategories(items: List<GoodsData>)
}
