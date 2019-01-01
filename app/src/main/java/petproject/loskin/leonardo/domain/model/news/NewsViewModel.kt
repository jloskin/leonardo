package petproject.loskin.leonardo.domain.model.news

import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.news.LeisureRepositories
import petproject.loskin.leonardo.util.rx.applySchedulers

class NewsViewModel(
  private val leisureInteractor: LeisureRepositories
) : ViewModel() {
  fun news() = leisureInteractor.getNews().applySchedulers()
}