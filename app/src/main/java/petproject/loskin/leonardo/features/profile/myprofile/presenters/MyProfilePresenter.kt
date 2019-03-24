package petproject.loskin.leonardo.features.profile.myprofile.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.profile.myprofile.repositories.MyProfileRepository
import petproject.loskin.leonardo.features.profile.myprofile.ui.MyProfileView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class MyProfilePresenter @Inject constructor(
    repository: MyProfileRepository
) : MvpPresenter<MyProfileView>() {

    init {
        repository.profile()
            .applySchedulers()
            .subscribe(viewState::update, Throwable::printStackTrace)
    }
}