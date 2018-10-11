package petproject.loskin.leonardo.presentation.ui.news

import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.presentation.presenter.news.NewsPresenter
import petproject.loskin.leonardo.presentation.view.news.NewsView
import javax.inject.Inject


class NewsFragment : MvpAppCompatFragment(), NewsView {

    @InjectPresenter
    @Inject
    lateinit var newsPresenter: NewsPresenter

    @ProvidePresenter
    fun presenter() = newsPresenter

    init {
        NewsComponentHandler.newsComponent.inject(this)
    }

    val adapter: NewsAdapter by lazy { NewsAdapter() }

    override fun updateNews(item: List<NewsBlock>) {
        adapter.update(item)
    }
}
