package petproject.loskin.leonardo.presentation.ui.authorize

import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.repositories.MainRepositories
import javax.inject.Inject

class AuthorizeInteractor @Inject constructor(
        private val mainRepositories: MainRepositories
) {
    fun authorize(login: String, password: String) = mainRepositories.authorize(login, password)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}
