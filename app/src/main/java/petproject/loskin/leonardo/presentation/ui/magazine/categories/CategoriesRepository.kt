package petproject.loskin.leonardo.presentation.ui.magazine.categories

import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.entity.magazine.CategoriesDao
import petproject.loskin.leonardo.data.network.RetrofitClientInstance

class CategoriesRepository(
        private val categoriesDao: CategoriesDao,
        private val categoriesMapper: CategoriesMapper
) {
    private val service = RetrofitClientInstance.retrofit.create(CategoriesService::class.java)

    fun categories() = service.loadGoodsCategories()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map(categoriesMapper::string2categoriesData)
            .doOnNext(categoriesDao::insertAll)
}
