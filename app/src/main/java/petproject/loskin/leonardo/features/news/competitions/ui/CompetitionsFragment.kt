package petproject.loskin.leonardo.features.news.competitions.ui

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.BaseFragment
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.features.news.competitions.di.DaggerCompetitionsComponent
import petproject.loskin.leonardo.features.news.competitions.models.CompetitionsBlock
import petproject.loskin.leonardo.features.news.competitions.presenters.CompetitionsPresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class CompetitionsFragment : BaseFragment(), CompetitionsView {
    @Inject lateinit var presenterLazy: dagger.Lazy<CompetitionsPresenter>
    @InjectPresenter lateinit var presenter: CompetitionsPresenter
    @ProvidePresenter fun provide(): CompetitionsPresenter {
        DaggerCompetitionsComponent.builder().navigationModule(MainActivity.ROOT).build().inject(this)
        return presenterLazy.get()
    }

    val adapter: CompetitionsAdapter by lazy { CompetitionsAdapter() }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun update(items: List<CompetitionsBlock>) {
        Utils.linearLayout(recyclerView, adapter)
        adapter.update(items)
    }
}