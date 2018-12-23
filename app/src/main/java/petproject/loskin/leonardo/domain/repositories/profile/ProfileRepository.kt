package petproject.loskin.leonardo.domain.repositories.profile

import petproject.loskin.leonardo.data.network.services.profile.ProfileService
import petproject.loskin.leonardo.domain.repositories.RetrofitRepository

class ProfileRepository : RetrofitRepository<ProfileService>(ProfileService::class.java)