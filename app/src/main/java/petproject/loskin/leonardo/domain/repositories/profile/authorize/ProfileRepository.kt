package petproject.loskin.leonardo.domain.repositories.profile.authorize

import petproject.loskin.leonardo.data.db.dao.profile.ProfileDao
import petproject.loskin.leonardo.data.db.dao.profile.User
import petproject.loskin.leonardo.data.mapper.profile.authorization.ProfileMapper
import petproject.loskin.leonardo.data.network.services.profile.authorization.ProfileService

class ProfileRepository(
  private val mapper: ProfileMapper,
  private val dao: ProfileDao,
  private val service: ProfileService
) {
  fun authorize(login: String, password: String) = service.authorize(login, password)
    .map(mapper::string2Response)
    .doOnNext { dao.insertUser(User(0, login, password)) }
    .map { it.isNotEmpty() }

  fun checkAuthorize() = dao.getUser()
    .map { it.firstOrNull() ?: throw UnAuthorized() }
    .toObservable()
    .flatMap { authorize(it.login, it.password) }
    .onErrorReturn { false }
}
