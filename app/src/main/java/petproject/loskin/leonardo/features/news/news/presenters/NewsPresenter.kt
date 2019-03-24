package petproject.loskin.leonardo.features.news.news.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.news.news.repositories.NewsRepository
import petproject.loskin.leonardo.features.news.news.ui.NewsView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class NewsPresenter @Inject constructor(
    interactor: NewsRepository
) : MvpPresenter<NewsView>() {
    init {
        interactor.getNews().applySchedulers()
            .subscribe(viewState::update, Throwable::printStackTrace)
    }
}