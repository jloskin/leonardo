package petproject.loskin.leonardo.features.shop.goods.di

import dagger.Component
import petproject.loskin.leonardo.base.db.di.DataBaseModule
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.shop.goods.ui.GoodsFragment

@Component(modules = [NavigationModule::class, GoodsModule::class, DataBaseModule::class])
interface GoodsComponent {
    fun inject(fragment: GoodsFragment)
}