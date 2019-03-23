package petproject.loskin.leonardo.base.ui

import android.os.Bundle
import android.view.View
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import kotlinx.android.synthetic.main.app_bar_main.*

abstract class RootFragment : BaseFragment() {
  val mainActivity: MainActivity get() = activity as MainActivity

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(mainActivity.toolbar) {
      title = (titleId()?.let(this@RootFragment::getString) ?: title())
      navigationIcon = navigationIconId()?.let { VectorDrawableCompat.create(resources, it, null) }
    }
  }

  open fun navigationIconId(): Int? = null

  open fun titleId(): Int? = null

  open fun title(): String? = null

  override fun onPause() {
    super.onPause()
    mainActivity.clearMenu()
  }
}