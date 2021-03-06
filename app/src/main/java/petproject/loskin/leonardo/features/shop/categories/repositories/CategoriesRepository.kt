package petproject.loskin.leonardo.features.shop.categories.repositories

import io.reactivex.Flowable
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import petproject.loskin.leonardo.base.db.dao.shop.ShopDao
import petproject.loskin.leonardo.features.shop.categories.mappers.CategoriesMapper
import petproject.loskin.leonardo.features.shop.categories.services.CategoriesService
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val shopDao: ShopDao,
    private val categoriesMapper: CategoriesMapper,
    private val service: CategoriesService
) {
    fun initMenu(): Flowable<List<MenuL>> = shopDao.menus()
        .flatMap {
            if (it.isEmpty()) service.menus().map(categoriesMapper::page2Menu).doOnNext(shopDao::insertMenus).flatMap { shopDao.menus() }
            else Flowable.just(it)
        }
}