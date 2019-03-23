package petproject.loskin.leonardo.features.profile.authorize.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface AuthorizationView : MvpView {
    fun authorize(success: Boolean)
}
