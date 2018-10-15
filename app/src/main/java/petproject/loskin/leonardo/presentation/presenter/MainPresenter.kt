package petproject.loskin.leonardo.presentation.presenter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import petproject.loskin.leonardo.domain.main.MainInteractor

class MainPresenter(
        private val mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application)
