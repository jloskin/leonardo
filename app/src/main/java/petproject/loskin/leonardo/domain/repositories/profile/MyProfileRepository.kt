package petproject.loskin.leonardo.domain.repositories.profile

import petproject.loskin.leonardo.data.mapper.profile.MyProfileMapper
import petproject.loskin.leonardo.data.network.services.profile.ProfileService

class MyProfileRepository(
  private val myProfileMapper: MyProfileMapper,
  private val service: ProfileService
) {
  fun profile() = service.profile()
    .map(myProfileMapper::string2ProfileData)
}