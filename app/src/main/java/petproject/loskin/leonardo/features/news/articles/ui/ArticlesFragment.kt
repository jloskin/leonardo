package petproject.loskin.leonardo.features.news.articles.ui

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.BaseFragment
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.features.news.articles.di.DaggerArticlesComponent
import petproject.loskin.leonardo.features.news.articles.presenters.ArticlesPresenter
import petproject.loskin.leonardo.features.news.base.models.NewsBlock
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class ArticlesFragment : BaseFragment(), ArticlesView {
    @Inject @InjectPresenter lateinit var presenter: ArticlesPresenter
    @ProvidePresenter fun provide() = presenter

    init {
        DaggerArticlesComponent.builder().navigationModule(MainActivity.ROOT).build().inject(this)
    }

    override fun layoutId(): Int = R.layout.recycler_view

    val adapter: ArticlesAdapter by lazy { ArticlesAdapter() }

    override fun update(list: List<NewsBlock>) {
        Utils.defaultList(recyclerView, adapter)
        adapter.update(list)
    }
}
