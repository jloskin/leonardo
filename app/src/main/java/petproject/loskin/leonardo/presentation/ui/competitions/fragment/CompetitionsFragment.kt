package petproject.loskin.leonardo.presentation.ui.competitions.fragment

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import petproject.loskin.leonardo.SampleApplication
import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock
import petproject.loskin.leonardo.presentation.presenter.competitions.CompetitionsPresenter
import petproject.loskin.leonardo.presentation.ui.articles.RecyclerViewFragment
import petproject.loskin.leonardo.presentation.ui.competitions.adapter.CompetitionsAdapter
import petproject.loskin.leonardo.presentation.view.competitions.CompetitionsView
import javax.inject.Inject

class CompetitionsFragment : RecyclerViewFragment(), CompetitionsView {
    @InjectPresenter
    @Inject
    lateinit var competitionsPresenter: CompetitionsPresenter

    @ProvidePresenter
    fun presenter() = competitionsPresenter

    init {
        SampleApplication.INSTANCE.appComponent.inject(this)
    }

    override val adapter: CompetitionsAdapter by lazy {
        CompetitionsAdapter()
    }

    override fun updateCompetitions(conpetitions: List<CompetitionsBlock>) {
        adapter.update(conpetitions)
    }
}