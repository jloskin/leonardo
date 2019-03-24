package petproject.loskin.leonardo.features.profile.myprofile.repositories

import petproject.loskin.leonardo.features.profile.ProfileService
import petproject.loskin.leonardo.features.profile.myprofile.mappers.MyProfileMapper
import javax.inject.Inject

class MyProfileRepository @Inject constructor(
    private val mapper: MyProfileMapper,
    private val service: ProfileService
) {
    fun profile() = service.profile()
        .map(mapper::page2ProfileData)
}