package petproject.loskin.leonardo.domain.repositories.shop.categories

import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.db.dao.magazine.categories.ShopDao
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.data.mapper.shop.categories.MagazineMapper
import petproject.loskin.leonardo.data.network.RetrofitClientInstance
import petproject.loskin.leonardo.data.network.services.shop.CategoriesService

class CategoriesRepository(
        private val shopDao: ShopDao,
        private val magazineMapper: MagazineMapper
) {
    private val service = RetrofitClientInstance.retrofit.create(CategoriesService::class.java)

    fun initMenu(): Flowable<List<MenuL>> = shopDao.menus()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .flatMap {
                if (it.isEmpty()) {
                    Flowable.zip(
                            service.cities().map(magazineMapper::string2Cities).doOnNext(shopDao::insertCities),
                            service.menus().map(magazineMapper::string2Menu).doOnNext(shopDao::insertMenus).flatMap { shopDao.menus() },
                            BiFunction { _, t2 -> t2 }
                    )
                } else
                    Flowable.just(it)
            }
}