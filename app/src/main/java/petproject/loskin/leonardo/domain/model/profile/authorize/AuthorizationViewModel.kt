package petproject.loskin.leonardo.domain.model.profile.authorize

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.profile.authorize.ProfileRepository
import petproject.loskin.leonardo.util.rx.applySchedulers

class AuthorizationViewModel(
  private val repository: ProfileRepository
) : ViewModel() {
  val authorized = MutableLiveData<Boolean>(false)

  fun authorize(login: String, password: String) =
    repository.authorize(login, password).applySchedulers()
      .subscribe(authorized::setValue, Throwable::printStackTrace)
}