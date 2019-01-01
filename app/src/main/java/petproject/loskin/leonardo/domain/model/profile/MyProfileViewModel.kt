package petproject.loskin.leonardo.domain.model.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.profile.MyProfileRepository
import petproject.loskin.leonardo.presentation.ui.profile.myprofile.ProfileData
import petproject.loskin.leonardo.util.rx.applySchedulers

class MyProfileViewModel(
  myProfileRepository: MyProfileRepository
) : ViewModel() {
  val subCategories = MutableLiveData<List<ProfileData>>()

  init {
    myProfileRepository.profile().applySchedulers()
      .subscribe(subCategories::setValue, Throwable::printStackTrace)
  }
}