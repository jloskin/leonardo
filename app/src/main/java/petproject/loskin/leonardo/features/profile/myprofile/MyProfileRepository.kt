package petproject.loskin.leonardo.features.profile.myprofile

import petproject.loskin.leonardo.features.profile.ProfileService
import javax.inject.Inject

class MyProfileRepository @Inject constructor(
    private val mapper: MyProfileMapper,
    private val service: ProfileService
) {
    fun profile() = service.profile()
        .map(mapper::string2ProfileData)
}