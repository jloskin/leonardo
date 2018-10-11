package petproject.loskin.leonardo.presentation.ui.magazine

import petproject.loskin.leonardo.di.DaggerMagazineComponent
import petproject.loskin.leonardo.di.MagazineComponent

object MagazineComponentHandler {
    val MAGAZINE_COMPONENT: MagazineComponent by lazy { DaggerMagazineComponent.create() }
}