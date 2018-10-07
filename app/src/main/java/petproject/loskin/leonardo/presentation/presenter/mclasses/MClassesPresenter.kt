package petproject.loskin.leonardo.presentation.presenter.mclasses

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.mclasses.MClassesView
import javax.inject.Inject

@InjectViewState
class MClassesPresenter @Inject constructor(
        private val mainInteractor: MainInteractor
) : MvpPresenter<MClassesView>() {
    init {
        mainInteractor.getMClasses()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::updateMClasses, Throwable::printStackTrace)
    }
}