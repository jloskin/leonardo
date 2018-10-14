package petproject.loskin.leonardo.presentation.ui.magazine.goods

import petproject.loskin.leonardo.data.entity.magazine.GoodsData

interface GoodsView {
    fun loadGoodsCategories(items: List<GoodsData>)
}
