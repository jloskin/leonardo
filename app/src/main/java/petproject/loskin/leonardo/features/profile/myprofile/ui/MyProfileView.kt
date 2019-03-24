package petproject.loskin.leonardo.features.profile.myprofile.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import petproject.loskin.leonardo.features.profile.myprofile.models.ProfileData

@StateStrategyType(AddToEndSingleStrategy::class)
interface MyProfileView : MvpView {
    fun update(items: List<ProfileData>)
}
