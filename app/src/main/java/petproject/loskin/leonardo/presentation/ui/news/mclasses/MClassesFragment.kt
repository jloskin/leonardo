package petproject.loskin.leonardo.presentation.ui.news.mclasses

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.news.mclasses.MClassesViewModel
import petproject.loskin.leonardo.presentation.ui.base.BaseFragment


class MClassesFragment : BaseFragment() {
  private val viewModel: MClassesViewModel by viewModel()

  val adapter: MClassesAdapter by lazy { MClassesAdapter() }

  override fun layoutId(): Int = R.layout.recycler_view

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.mclasses().subscribe(adapter::update, Throwable::printStackTrace)
    with(recyclerView) {
      val linearLayoutManager = LinearLayoutManager(context)
      layoutManager = linearLayoutManager
      addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
      adapter = this@MClassesFragment.adapter
    }
  }
}
