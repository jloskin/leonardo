package petproject.loskin.leonardo.domain.model.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.MainInteractor

class NewsViewModel(
        private val mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {

    fun news() = mainInteractor.getNews().observeOn(AndroidSchedulers.mainThread())
}
