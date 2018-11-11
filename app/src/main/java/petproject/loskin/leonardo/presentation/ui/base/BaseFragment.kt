package petproject.loskin.leonardo.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router

abstract class BaseFragment : Fragment() {
    val router: Router by inject()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutId(), container, false)

    abstract fun layoutId(): Int
}