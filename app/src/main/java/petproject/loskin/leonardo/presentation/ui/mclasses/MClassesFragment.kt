package petproject.loskin.leonardo.presentation.ui.mclasses

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import petproject.loskin.leonardo.SampleApplication
import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock
import petproject.loskin.leonardo.presentation.presenter.mclasses.MClassesPresenter
import petproject.loskin.leonardo.presentation.ui.articles.RecyclerViewFragment
import petproject.loskin.leonardo.presentation.view.mclasses.MClassesView
import javax.inject.Inject


class MClassesFragment : RecyclerViewFragment(), MClassesView {
    @InjectPresenter
    @Inject
    lateinit var newsPresenter: MClassesPresenter

    @ProvidePresenter
    fun presenter() = newsPresenter

    init {
        SampleApplication.INSTANCE.appComponent.inject(this)
    }

    override fun updateMClasses(item: List<CompetitionsBlock>) {
        adapter.update(item)
    }

    override val adapter: MClassesAdapter by lazy {
        MClassesAdapter()
    }
}
