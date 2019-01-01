package petproject.loskin.leonardo.domain.repositories.profile.authorize

import petproject.loskin.leonardo.data.db.dao.profile.ProfileDao
import petproject.loskin.leonardo.data.db.dao.profile.User
import petproject.loskin.leonardo.data.mapper.profile.authorization.AuthorizationMapper
import petproject.loskin.leonardo.data.network.services.profile.authorization.AuthorizeService

class AuthorizeRepository(
  private val authorizationMapper: AuthorizationMapper,
  private val profileDao: ProfileDao,
  private val service: AuthorizeService
) {
  fun authorize(login: String, password: String) = service.authorize(login, password)
    .map(authorizationMapper::string2Response)
    .doOnNext {
      profileDao.insertUser(User(
        0,
        "",
        ""
      ))
    }
}
