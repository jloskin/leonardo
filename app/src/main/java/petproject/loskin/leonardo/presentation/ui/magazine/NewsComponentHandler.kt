package petproject.loskin.leonardo.presentation.ui.magazine

import petproject.loskin.leonardo.di.DaggerNewsComponent
import petproject.loskin.leonardo.di.NewsComponent

object NewsComponentHandler {
    val newsComponent: NewsComponent by lazy { DaggerNewsComponent.create() }
}