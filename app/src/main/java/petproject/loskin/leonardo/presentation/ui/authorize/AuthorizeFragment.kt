package petproject.loskin.leonardo.presentation.ui.authorize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.authorization_screen.*
import petproject.loskin.leonardo.R

class AuthorizeFragment : Fragment() {
    lateinit var presenter: AuthorizePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.authorization_screen, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        enter.setOnClickListener { _ ->
            presenter.authorize(email.text.toString(), password.text.toString())
        }
    }
}
