package petproject.loskin.leonardo.presentation.ui.news.competitions.fragment

import petproject.loskin.leonardo.data.entity.news.competitions.CompetitionsBlock
import petproject.loskin.leonardo.presentation.presenter.news.competitions.CompetitionsPresenter
import petproject.loskin.leonardo.presentation.ui.news.articles.RecyclerViewFragment
import petproject.loskin.leonardo.presentation.ui.news.competitions.adapter.CompetitionsAdapter

class CompetitionsFragment : RecyclerViewFragment() {
    lateinit var competitionsPresenter: CompetitionsPresenter

    override val adapter: CompetitionsAdapter by lazy { CompetitionsAdapter() }

    fun updateCompetitions(conpetitions: List<CompetitionsBlock>) {
        adapter.update(conpetitions)
    }
}