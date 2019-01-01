package petproject.loskin.leonardo.domain.model.profile.authorize

import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.profile.authorize.AuthorizeRepository
import petproject.loskin.leonardo.util.rx.applySchedulers

class AuthorizeViewModel(
  private val authorizeRepository: AuthorizeRepository
) : ViewModel() {
  fun authorize(login: String, password: String) = authorizeRepository.authorize(login, password).applySchedulers()
}