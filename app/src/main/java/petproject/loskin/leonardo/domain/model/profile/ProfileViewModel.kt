package petproject.loskin.leonardo.domain.model.profile

import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.profile.ProfileRepository

class ProfileViewModel(
  private val profileRepository: ProfileRepository
) : ViewModel()