package petproject.loskin.leonardo.presentation.presenter.news.articles

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor

class ArticlesPresenter(
        mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {

    init {
        mainInteractor.getArticles()
                .firstElement()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, Throwable::printStackTrace)
    }
}
