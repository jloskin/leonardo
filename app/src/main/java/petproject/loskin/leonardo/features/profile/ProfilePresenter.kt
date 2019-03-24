package petproject.loskin.leonardo.features.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.profile.authorize.repositories.ProfileRepository
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    profileRepository: ProfileRepository
) : MvpPresenter<ProfileView>() {
    init {
        profileRepository.checkAuthorize().applySchedulers()
            .subscribe(viewState::authorization, Throwable::printStackTrace)
    }
}
