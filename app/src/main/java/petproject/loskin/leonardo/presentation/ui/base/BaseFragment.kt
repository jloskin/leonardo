package petproject.loskin.leonardo.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import kotlinx.android.synthetic.main.app_bar_main.*
import org.koin.android.ext.android.inject
import petproject.loskin.leonardo.presentation.ui.MainActivity
import ru.terrakok.cicerone.Router

abstract class BaseFragment : Fragment() {
    val router: Router by inject()
    val mainActivity: MainActivity get() = activity as MainActivity

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutId(), container, false)

    abstract fun layoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(mainActivity.toolbar) {
            title = titleId()?.let(this@BaseFragment::getString) ?: title()
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