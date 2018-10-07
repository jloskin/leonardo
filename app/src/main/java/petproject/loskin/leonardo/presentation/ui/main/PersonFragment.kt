package petproject.loskin.leonardo.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.authorization_screen.*
import petproject.loskin.leonardo.R

class PersonFragment : MvpAppCompatFragment(), AuthorizeView {

    @InjectPresenter
    lateinit var newsPresenter: AuthorizePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.authorization_screen, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        enter.setOnClickListener {
            newsPresenter.authorize(email.text.toString(), password.text.toString())
                    .subscribe({}, Throwable::printStackTrace)
        }
    }
}
