package petproject.loskin.leonardo.presentation.presenter.mclasses

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.mclasses.MClassesView
import javax.inject.Inject

class MClassesPresenter @Inject constructor(
        private val mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {
    init {
        mainInteractor.getMClasses()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, Throwable::printStackTrace)
    }
}