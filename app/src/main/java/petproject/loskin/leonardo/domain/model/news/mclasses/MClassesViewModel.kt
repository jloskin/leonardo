package petproject.loskin.leonardo.domain.model.news.mclasses

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.LeisureInteractor

class MClassesViewModel(
  private val leisureInteractor: LeisureInteractor
) : ViewModel() {
  fun mclasses() = leisureInteractor.getMClasses()
    .observeOn(AndroidSchedulers.mainThread())
}