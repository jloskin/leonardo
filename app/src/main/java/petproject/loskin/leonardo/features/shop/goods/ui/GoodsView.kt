package petproject.loskin.leonardo.features.shop.goods.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import petproject.loskin.leonardo.features.shop.goods.features.filters.models.Filter
import petproject.loskin.leonardo.features.shop.goods.models.GoodsData

@StateStrategyType(AddToEndSingleStrategy::class)
interface GoodsView : MvpView {
    fun updateMenu(items: List<MenuL>)

    fun updateGoods(items: List<GoodsData>)

    fun updateFilters(items: List<Filter>)
}
