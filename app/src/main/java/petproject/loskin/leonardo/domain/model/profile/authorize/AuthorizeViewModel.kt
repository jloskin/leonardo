package petproject.loskin.leonardo.domain.model.profile.authorize

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.repositories.profile.authorize.AuthorizeRepository

class AuthorizeViewModel(
  private val authorizeRepository: AuthorizeRepository
) : ViewModel() {
  fun authorize(login: String, password: String) = authorizeRepository.authorize(login, password)
    .observeOn(AndroidSchedulers.mainThread())
}