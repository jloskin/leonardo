package petproject.loskin.leonardo.presentation.ui.main

import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.repositories.MainRepositories

class AuthorizeInteractor(
        private val mainRepositories: MainRepositories = MainRepositories()
) {
    fun authorize(login: String, password: String) = mainRepositories.authorize(login, password)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}
