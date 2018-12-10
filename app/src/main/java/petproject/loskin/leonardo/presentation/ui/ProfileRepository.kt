package petproject.loskin.leonardo.presentation.ui

import petproject.loskin.leonardo.data.network.services.profile.ProfileService
import petproject.loskin.leonardo.domain.repositories.profile.authorize.RetrofitRepository

class ProfileRepository : RetrofitRepository<ProfileService>(ProfileService::class.java)