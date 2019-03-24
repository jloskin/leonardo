package petproject.loskin.leonardo.features.news.mclasses.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import petproject.loskin.leonardo.features.news.competitions.models.CompetitionsBlock

@StateStrategyType(AddToEndSingleStrategy::class)
interface MClassesView : MvpView {
    fun update(items: List<CompetitionsBlock>)
}
