package petproject.loskin.leonardo.presentation.presenter.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor

class NewsPresenter(
        private val mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {

    init {
        mainInteractor.getNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, Throwable::printStackTrace)
    }
}
