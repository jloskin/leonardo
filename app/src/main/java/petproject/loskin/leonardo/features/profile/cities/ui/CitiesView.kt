package petproject.loskin.leonardo.features.profile.cities.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import petproject.loskin.leonardo.base.db.dao.profile.City

@StateStrategyType(AddToEndSingleStrategy::class)
interface CitiesView : MvpView {
    fun update(items: List<City>)
}
