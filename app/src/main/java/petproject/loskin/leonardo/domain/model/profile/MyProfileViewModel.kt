package petproject.loskin.leonardo.domain.model.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.repositories.profile.MyProfileRepository
import petproject.loskin.leonardo.presentation.ui.profile.myprofile.ProfileData

class MyProfileViewModel(
  myProfileRepository: MyProfileRepository
) : ViewModel() {
  val subCategories = MutableLiveData<List<ProfileData>>()

  init {
    myProfileRepository.profile()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(subCategories::setValue, Throwable::printStackTrace)
  }
}