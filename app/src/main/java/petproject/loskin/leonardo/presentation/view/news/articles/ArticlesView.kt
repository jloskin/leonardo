package petproject.loskin.leonardo.presentation.view.news.articles

import petproject.loskin.leonardo.data.entity.news.NewsBlock

interface ArticlesView {

    fun updateArticles(item: List<NewsBlock>)

}
