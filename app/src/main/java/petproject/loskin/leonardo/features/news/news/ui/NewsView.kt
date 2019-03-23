package petproject.loskin.leonardo.features.news.news.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import petproject.loskin.leonardo.features.news.base.models.NewsBlock

@StateStrategyType(AddToEndSingleStrategy::class)
interface NewsView : MvpView {
  fun update(items: List<NewsBlock>)
}
