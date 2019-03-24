package petproject.loskin.leonardo.features.profile.authorize.repositories

import io.reactivex.Observable
import petproject.loskin.leonardo.base.db.dao.profile.ProfileDao
import petproject.loskin.leonardo.base.db.dao.profile.User
import petproject.loskin.leonardo.features.profile.ProfileMapper
import petproject.loskin.leonardo.features.profile.ProfileService
import petproject.loskin.leonardo.features.profile.authorize.exceptions.UnAuthorized
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val mapper: ProfileMapper,
    private val dao: ProfileDao,
    private val service: ProfileService
) {
    fun authorize(login: String, password: String): Observable<Boolean> = service.authorize(login, password)
        .map(mapper::string2Response)
        .doOnNext { dao.insertUser(User(login, password)) }
        .map { it.isNotEmpty() }

    fun checkAuthorize(): Observable<Boolean> = dao.getUser()
        .map { it.firstOrNull() ?: throw UnAuthorized() }
        .toObservable()
        .flatMap { authorize(it.login, it.password) }
        .onErrorReturn { false }
}