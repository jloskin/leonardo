package petproject.loskin.leonardo.domain.model.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.LeisureInteractor

class NewsViewModel(
  private val leisureInteractor: LeisureInteractor,
  application: Application
) : AndroidViewModel(application) {

  fun news() = leisureInteractor.getNews().observeOn(AndroidSchedulers.mainThread())
}
