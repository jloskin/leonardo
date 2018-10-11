package petproject.loskin.leonardo.presentation.ui.articles

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.presentation.presenter.articles.ArticlesPresenter
import petproject.loskin.leonardo.presentation.ui.news.NewsComponentHandler
import petproject.loskin.leonardo.presentation.view.articles.ArticlesView
import javax.inject.Inject

class ArticlesFragment : RecyclerViewFragment(), ArticlesView {
    @InjectPresenter
    @Inject
    lateinit var newsPresenter: ArticlesPresenter

    @ProvidePresenter
    fun presenter() = newsPresenter

    init {
        NewsComponentHandler.newsComponent.inject(this)
    }

    override val adapter: ArticlesAdapter by lazy { ArticlesAdapter() }

    override fun updateArticles(item: List<NewsBlock>) {
        adapter.update(item)
    }
}
