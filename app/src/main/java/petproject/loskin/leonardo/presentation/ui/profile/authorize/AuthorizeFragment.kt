package petproject.loskin.leonardo.presentation.ui.profile.authorize

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.authorization_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.profile.authorize.AuthorizeViewModel
import petproject.loskin.leonardo.presentation.ui.base.RootFragment

class AuthorizeFragment : RootFragment() {
    override fun layoutId(): Int = R.layout.authorization_screen

    override fun titleId(): Int = R.string.authorization

    val viewModel: AuthorizeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enter.setOnClickListener {
            viewModel.authorize(email.text.toString(), password.text.toString())
        }
    }
}
