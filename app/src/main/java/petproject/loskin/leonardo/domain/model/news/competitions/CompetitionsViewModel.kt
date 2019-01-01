package petproject.loskin.leonardo.domain.model.news.competitions

import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.news.LeisureRepositories
import petproject.loskin.leonardo.util.rx.applySchedulers

class CompetitionsViewModel(
  private val leisureInteractor: LeisureRepositories
) : ViewModel() {
  fun competitons() = leisureInteractor.getCompetitions().applySchedulers()
}