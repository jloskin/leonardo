package petproject.loskin.leonardo.domain.repositories.profile

import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.network.services.profile.ProfileService
import petproject.loskin.leonardo.domain.repositories.RetrofitRepository

class MyProfileRepository(
  private val myProfileMapper: MyProfileMapper
) : RetrofitRepository<ProfileService>(ProfileService::class.java) {
  fun profile() = service.profile()
    .subscribeOn(Schedulers.io())
    .unsubscribeOn(Schedulers.io())
    .observeOn(Schedulers.io())
    .map(myProfileMapper::string2ProfileData)
}