package petproject.loskin.leonardo.presentation.view.articles

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock
import petproject.loskin.leonardo.data.entity.news.NewsBlock

interface ArticlesView : MvpView {

    fun updateArticles(item: List<NewsBlock>)

}
