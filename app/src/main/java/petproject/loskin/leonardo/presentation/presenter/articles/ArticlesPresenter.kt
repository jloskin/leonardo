package petproject.loskin.leonardo.presentation.presenter.articles

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.articles.ArticlesView
import javax.inject.Inject

@InjectViewState
class ArticlesPresenter @Inject constructor(
        mainInteractor: MainInteractor
) : MvpPresenter<ArticlesView>() {

    init {
        mainInteractor.getArticles()
                .firstElement()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::updateArticles, Throwable::printStackTrace)
    }
}
