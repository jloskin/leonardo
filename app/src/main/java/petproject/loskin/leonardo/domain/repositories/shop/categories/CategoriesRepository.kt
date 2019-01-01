package petproject.loskin.leonardo.domain.repositories.shop.categories

import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import petproject.loskin.leonardo.data.db.dao.magazine.categories.ShopDao
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.data.mapper.shop.categories.CategoriesMapper
import petproject.loskin.leonardo.data.network.services.shop.categories.CategoriesService

class CategoriesRepository(
  private val shopDao: ShopDao,
  private val categoriesMapper: CategoriesMapper,
  private val service: CategoriesService
) {
  fun initMenu(): Flowable<List<MenuL>> = shopDao.menus()
    .flatMap {
      if (it.isEmpty()) {
        Flowable.zip(
          service.cities().map(categoriesMapper::string2Cities).doOnNext(shopDao::insertCities),
          service.menus().map(categoriesMapper::string2Menu).doOnNext(shopDao::insertMenus).flatMap { shopDao.menus() },
          BiFunction { _, t2 -> t2 }
        )
      } else
        Flowable.just(it)
    }
}