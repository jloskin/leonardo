package petproject.loskin.leonardo.domain.repositories.profile.authorize

import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.network.RetrofitClientInstance
import petproject.loskin.leonardo.data.network.services.profile.authorization.AuthorizeService

class AuthorizeRepositories {
    private val service = RetrofitClientInstance.retrofit.create(AuthorizeService::class.java)

    fun authorize(login: String, password: String) = service.authorize(login, password)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}
