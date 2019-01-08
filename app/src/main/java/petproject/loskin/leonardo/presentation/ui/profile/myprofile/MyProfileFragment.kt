package petproject.loskin.leonardo.presentation.ui.profile.myprofile

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.android.ext.android.inject
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.profile.MyProfileViewModel
import petproject.loskin.leonardo.presentation.ui.base.RootFragment

class MyProfileFragment : RootFragment() {
  private val viewModel: MyProfileViewModel by inject()

  private val adapter by lazy { MyProfileAdapter() }

  override fun layoutId(): Int = R.layout.recycler_view

  override fun titleId(): Int = R.string.profile_profile

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(recyclerView) {
      adapter = this@MyProfileFragment.adapter
      layoutManager = LinearLayoutManager(context)
    }

    viewModel.subCategories.observe(this, Observer(adapter::update))
  }
}
