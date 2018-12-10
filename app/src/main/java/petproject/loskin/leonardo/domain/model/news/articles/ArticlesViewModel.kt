package petproject.loskin.leonardo.domain.model.news.articles

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.LeisureInteractor

class ArticlesViewModel(
  private val leisureInteractor: LeisureInteractor
) : ViewModel() {
  fun articles() = leisureInteractor.getArticles()
    .observeOn(AndroidSchedulers.mainThread())
}
