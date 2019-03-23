package petproject.loskin.leonardo.features.profile.authorize.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.profile.authorize.repositories.ProfileRepository
import petproject.loskin.leonardo.features.profile.authorize.ui.AuthorizationView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class AuthorizationPresenter @Inject constructor(
  private val repository: ProfileRepository
) : MvpPresenter<AuthorizationView>() {

  fun authorize(login: String, password: String) =
    repository.authorize(login, password).applySchedulers()
      .subscribe(viewState::authorize, Throwable::printStackTrace)
}