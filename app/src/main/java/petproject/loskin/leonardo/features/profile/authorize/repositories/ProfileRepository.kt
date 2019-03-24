package petproject.loskin.leonardo.features.profile.authorize.repositories

import io.reactivex.Observable
import petproject.loskin.leonardo.base.db.dao.profile.ProfileDao
import petproject.loskin.leonardo.base.db.dao.profile.Profile
import petproject.loskin.leonardo.features.profile.base.mappers.ProfileMapper
import petproject.loskin.leonardo.features.profile.base.services.ProfileService
import petproject.loskin.leonardo.features.profile.authorize.exceptions.UnAuthorized
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val mapper: ProfileMapper,
    private val dao: ProfileDao,
    private val service: ProfileService
) {
    fun authorize(login: String, password: String): Observable<Boolean> = service.authorize(login, password)
        .map(mapper::page2Response)
        .doOnNext { dao.insertUser(Profile(login, password)) }
        .map { it.isNotEmpty() }

    fun checkAuthorize(): Observable<Boolean> = dao.getUser()
        .map { it.firstOrNull() ?: throw UnAuthorized() }
        .toObservable()
        .flatMap { authorize(it.login, it.password) }
        .onErrorReturn { false }
}