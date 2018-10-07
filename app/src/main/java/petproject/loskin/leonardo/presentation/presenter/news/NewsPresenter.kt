package petproject.loskin.leonardo.presentation.presenter.news

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.news.NewsView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class NewsPresenter @Inject constructor(
        private val mainInteractor: MainInteractor,
        private val router: Router
) : MvpPresenter<NewsView>() {

    init {
        mainInteractor.getNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::updateNews, Throwable::printStackTrace)
    }
}
