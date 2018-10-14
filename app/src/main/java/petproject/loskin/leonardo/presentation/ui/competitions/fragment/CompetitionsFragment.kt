package petproject.loskin.leonardo.presentation.ui.competitions.fragment

import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock
import petproject.loskin.leonardo.di.Injectable
import petproject.loskin.leonardo.presentation.presenter.competitions.CompetitionsPresenter
import petproject.loskin.leonardo.presentation.ui.articles.RecyclerViewFragment
import petproject.loskin.leonardo.presentation.ui.competitions.adapter.CompetitionsAdapter
import javax.inject.Inject

class CompetitionsFragment : RecyclerViewFragment(), Injectable {
    @Inject
    lateinit var competitionsPresenter: CompetitionsPresenter

    override val adapter: CompetitionsAdapter by lazy { CompetitionsAdapter() }

    fun updateCompetitions(conpetitions: List<CompetitionsBlock>) {
        adapter.update(conpetitions)
    }
}