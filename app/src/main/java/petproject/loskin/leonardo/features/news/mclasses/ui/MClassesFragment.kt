package petproject.loskin.leonardo.features.news.mclasses.ui

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.BaseFragment
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.features.news.competitions.models.CompetitionsBlock
import petproject.loskin.leonardo.features.news.mclasses.di.DaggerMClassesComponent
import petproject.loskin.leonardo.features.news.mclasses.presenters.MClassesPresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class MClassesFragment : BaseFragment(), MClassesView {
    @Inject lateinit var presenterLazy: dagger.Lazy<MClassesPresenter>
    @InjectPresenter lateinit var presenter: MClassesPresenter
    @ProvidePresenter fun provide(): MClassesPresenter {
        DaggerMClassesComponent.builder().navigationModule(MainActivity.ROOT).build().inject(this)
        return presenterLazy.get()
    }

    private val adapter: MClassesAdapter by lazy { MClassesAdapter() }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun update(items: List<CompetitionsBlock>) {
        Utils.linearLayout(recyclerView, adapter)
        adapter.update(items)
    }
}
