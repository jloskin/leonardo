package petproject.loskin.leonardo.presentation.ui.news.competitions.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.news.competitions.CompetitionsPresenter
import petproject.loskin.leonardo.presentation.ui.news.competitions.adapter.CompetitionsAdapter

class CompetitionsFragment : Fragment() {
    private val competitionsPresenter: CompetitionsPresenter by viewModel()

    val adapter: CompetitionsAdapter by lazy { CompetitionsAdapter() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.recycler_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        competitionsPresenter.competitons().subscribe(adapter::update, Throwable::printStackTrace)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@CompetitionsFragment.adapter
        }
    }
}