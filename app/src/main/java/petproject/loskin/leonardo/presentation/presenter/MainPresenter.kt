package petproject.loskin.leonardo.presentation.presenter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.main.MainView
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application)
