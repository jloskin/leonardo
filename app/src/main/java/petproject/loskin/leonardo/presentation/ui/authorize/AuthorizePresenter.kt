package petproject.loskin.leonardo.presentation.ui.authorize

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class AuthorizePresenter(
        private val authorzeInteractor: AuthorizeInteractor,
        application: Application
) : AndroidViewModel(application) {
    fun authorize(login: String, password: String) = authorzeInteractor.authorize(login, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, Throwable::printStackTrace)
}
