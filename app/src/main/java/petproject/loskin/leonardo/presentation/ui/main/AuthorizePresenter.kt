package petproject.loskin.leonardo.presentation.ui.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers

@InjectViewState
class AuthorizePresenter(
        private val authorzeInteractor: AuthorizeInteractor = AuthorizeInteractor()
) : MvpPresenter<AuthorizeView>() {
    fun authorize(login: String, password: String) = authorzeInteractor.authorize(login, password)
            .observeOn(AndroidSchedulers.mainThread())
}
