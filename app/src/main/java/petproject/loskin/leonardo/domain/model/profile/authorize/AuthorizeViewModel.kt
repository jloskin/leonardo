package petproject.loskin.leonardo.domain.model.profile.authorize

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.repositories.profile.authorize.AuthorizeRepositories

class AuthorizeViewModel(
        private val authorizeRepositories: AuthorizeRepositories
) : ViewModel() {
    fun authorize(login: String, password: String) = authorizeRepositories.authorize(login, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, Throwable::printStackTrace)
}
