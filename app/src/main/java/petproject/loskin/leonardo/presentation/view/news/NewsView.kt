package petproject.loskin.leonardo.presentation.view.news

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.data.entity.news.NewsBlock

interface NewsView : MvpView {

    fun updateNews(item: List<NewsBlock>)

}
