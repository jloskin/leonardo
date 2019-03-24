package petproject.loskin.leonardo.features.shop.subcategories.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import petproject.loskin.leonardo.base.db.dao.shop.MenuL

@StateStrategyType(AddToEndSingleStrategy::class)
interface SubCategoriesView : MvpView {
    fun update(list: List<MenuL>)
}
