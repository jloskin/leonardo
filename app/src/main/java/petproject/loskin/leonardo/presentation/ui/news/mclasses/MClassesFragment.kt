package petproject.loskin.leonardo.presentation.ui.news.mclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.news.mclasses.MClassesPresenter


class MClassesFragment : Fragment() {
    private val newsPresenter: MClassesPresenter by viewModel()

    val adapter: MClassesAdapter by lazy { MClassesAdapter() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.recycler_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsPresenter.mclasses().subscribe(adapter::update, Throwable::printStackTrace)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MClassesFragment.adapter
        }
    }
}
