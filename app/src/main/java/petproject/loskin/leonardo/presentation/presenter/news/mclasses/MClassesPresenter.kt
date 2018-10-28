package petproject.loskin.leonardo.presentation.presenter.news.mclasses

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor

class MClassesPresenter(
        private val mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {
    fun mclasses() = mainInteractor.getMClasses()
            .observeOn(AndroidSchedulers.mainThread())
}