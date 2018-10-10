package petproject.loskin.leonardo.presentation.ui.magazine

import petproject.loskin.leonardo.di.DaggerGoodsComponent
import petproject.loskin.leonardo.di.GoodsComponent

object GoodsComponentHandler {
    val goodsComponent: GoodsComponent by lazy { DaggerGoodsComponent.create() }
}