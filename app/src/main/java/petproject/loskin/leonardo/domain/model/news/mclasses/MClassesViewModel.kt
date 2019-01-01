package petproject.loskin.leonardo.domain.model.news.mclasses

import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.domain.repositories.news.LeisureRepositories
import petproject.loskin.leonardo.util.rx.applySchedulers

class MClassesViewModel(
  private val leisureInteractor: LeisureRepositories
) : ViewModel() {
  fun mclasses() = leisureInteractor.getMClasses().applySchedulers()
}