package petproject.loskin.leonardo.presentation.view.news

import petproject.loskin.leonardo.data.entity.news.NewsBlock

interface NewsView {

    fun updateNews(item: List<NewsBlock>)

}
