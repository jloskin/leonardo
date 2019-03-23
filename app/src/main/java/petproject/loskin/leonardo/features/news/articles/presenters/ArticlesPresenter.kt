package petproject.loskin.leonardo.features.news.articles.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.news.articles.repositories.ArticlesRepository
import petproject.loskin.leonardo.features.news.articles.ui.ArticlesView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class ArticlesPresenter @Inject constructor(
  repository: ArticlesRepository
) : MvpPresenter<ArticlesView>() {
  init {
    repository.getArticles().applySchedulers()
      .subscribe(viewState::update, Throwable::printStackTrace)
  }
}
