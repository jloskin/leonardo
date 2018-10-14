package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.view.BackButtonListener

abstract class NavigatorFragment : Fragment(), BackButtonListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.news_screen, null)
}
