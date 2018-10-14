package petproject.loskin.leonardo.presentation.presenter.articles

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.articles.ArticlesView
import javax.inject.Inject

class ArticlesPresenter @Inject constructor(
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
