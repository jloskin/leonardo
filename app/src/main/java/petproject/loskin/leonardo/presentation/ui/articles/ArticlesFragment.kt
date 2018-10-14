package petproject.loskin.leonardo.presentation.ui.articles

import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.di.Injectable
import petproject.loskin.leonardo.presentation.presenter.articles.ArticlesPresenter
import javax.inject.Inject

class ArticlesFragment : RecyclerViewFragment(), Injectable {
    @Inject
    lateinit var newsPresenter: ArticlesPresenter

    override val adapter: ArticlesAdapter by lazy { ArticlesAdapter() }

    fun updateArticles(item: List<NewsBlock>) {
        adapter.update(item)
    }
}
