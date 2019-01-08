package petproject.loskin.leonardo.domain.model.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.profile.authorize.ProfileRepository
import petproject.loskin.leonardo.util.rx.applySchedulers

class ProfileViewModel(
  profileRepository: ProfileRepository
) : ViewModel() {
  val authorized = MutableLiveData<Boolean>()

  init {
    profileRepository.checkAuthorize().applySchedulers()
      .subscribe(authorized::setValue, Throwable::printStackTrace)
  }
}
