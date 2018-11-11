package petproject.loskin.leonardo.domain.model.news.articles

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.MainInteractor

class ArticlesPresenter(
        private val mainInteractor: MainInteractor
) : ViewModel() {

    fun articles() = mainInteractor.getArticles()
            .observeOn(AndroidSchedulers.mainThread())
}
