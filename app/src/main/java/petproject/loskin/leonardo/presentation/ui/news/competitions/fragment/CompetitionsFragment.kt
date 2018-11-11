package petproject.loskin.leonardo.presentation.ui.news.competitions.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.news.competitions.CompetitionsPresenter
import petproject.loskin.leonardo.presentation.ui.base.BaseFragment
import petproject.loskin.leonardo.presentation.ui.news.competitions.adapter.CompetitionsAdapter

class CompetitionsFragment : BaseFragment() {
    private val competitionsPresenter: CompetitionsPresenter by viewModel()

    val adapter: CompetitionsAdapter by lazy { CompetitionsAdapter() }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        competitionsPresenter.competitons().subscribe(adapter::update, Throwable::printStackTrace)
        with(recyclerView) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            adapter = this@CompetitionsFragment.adapter
        }
    }
}