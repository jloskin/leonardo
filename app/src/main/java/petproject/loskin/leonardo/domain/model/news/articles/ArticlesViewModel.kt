package petproject.loskin.leonardo.domain.model.news.articles

import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.news.LeisureRepositories
import petproject.loskin.leonardo.util.rx.applySchedulers

class ArticlesViewModel(
  private val leisureInteractor: LeisureRepositories
) : ViewModel() {
  fun articles() = leisureInteractor.getArticles().applySchedulers()
}
