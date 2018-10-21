package petproject.loskin.leonardo.presentation.ui.news.articles

import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.presentation.presenter.news.articles.ArticlesPresenter

class ArticlesFragment : RecyclerViewFragment() {
    lateinit var newsPresenter: ArticlesPresenter

    override val adapter: ArticlesAdapter by lazy { ArticlesAdapter() }

    fun updateArticles(item: List<NewsBlock>) {
        adapter.update(item)
    }
}
