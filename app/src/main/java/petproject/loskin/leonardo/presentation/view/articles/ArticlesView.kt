package petproject.loskin.leonardo.presentation.view.articles

import petproject.loskin.leonardo.data.entity.news.NewsBlock

interface ArticlesView {

    fun updateArticles(item: List<NewsBlock>)

}
