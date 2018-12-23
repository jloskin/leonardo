package petproject.loskin.leonardo.domain.repositories.profile.authorize

import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.db.dao.profile.ProfileDao
import petproject.loskin.leonardo.data.db.dao.profile.User
import petproject.loskin.leonardo.data.mapper.authorization.AuthorizationMapper
import petproject.loskin.leonardo.data.network.services.profile.authorization.AuthorizeService
import petproject.loskin.leonardo.domain.repositories.RetrofitRepository

class AuthorizeRepository(
  private val authorizationMapper: AuthorizationMapper,
  private val profileDao: ProfileDao
) : RetrofitRepository<AuthorizeService>(AuthorizeService::class.java) {
  fun authorize(login: String, password: String) = service.authorize(login, password)
    .subscribeOn(Schedulers.io())
    .unsubscribeOn(Schedulers.io())
    .observeOn(Schedulers.io())
    .map(authorizationMapper::string2Response)
    .doOnNext {
      profileDao.insertUser(User(
        0,
        "",
        ""
      ))
    }
}
