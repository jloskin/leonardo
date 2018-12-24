package petproject.loskin.leonardo.domain.model.news

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.LeisureInteractor

class NewsViewModel(
  private val leisureInteractor: LeisureInteractor
) : ViewModel() {

  fun news() = leisureInteractor.getNews().observeOn(AndroidSchedulers.mainThread())
}
