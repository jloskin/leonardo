package petproject.loskin.leonardo.domain.model.news.competitions

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.LeisureInteractor

class CompetitionsViewModel(
  private val leisureInteractor: LeisureInteractor
) : ViewModel() {
  fun competitons() = leisureInteractor.getCompetitions()
    .observeOn(AndroidSchedulers.mainThread())
}