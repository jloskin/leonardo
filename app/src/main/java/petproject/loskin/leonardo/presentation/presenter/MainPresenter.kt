package petproject.loskin.leonardo.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.main.MainView
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val mainInteractor: MainInteractor
) : MvpPresenter<MainView>()
