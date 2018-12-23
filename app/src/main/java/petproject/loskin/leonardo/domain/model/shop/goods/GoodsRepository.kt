package petproject.loskin.leonardo.domain.model.shop.goods

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.db.dao.magazine.categories.ShopDao
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.data.entity.shop.goods.GoodsData
import petproject.loskin.leonardo.data.network.services.shop.GoodsService
import petproject.loskin.leonardo.domain.repositories.RetrofitRepository

class GoodsRepository(
  private val shopDao: ShopDao,
  private val goodsMapper: GoodsMapper
) : RetrofitRepository<GoodsService>(GoodsService::class.java) {
  val filters: MutableList<Filter> = mutableListOf()

  fun chips(item: String): Flowable<List<MenuL>> = shopDao.menus(item)

  fun getGoods(item: String, page: String = ""): Observable<List<GoodsData>> = service.goods(item)
    .subscribeOn(Schedulers.io())
    .unsubscribeOn(Schedulers.io())
    .observeOn(Schedulers.io())
    .doOnNext {
      if (filters.isEmpty())
        filters.addAll(goodsMapper.string2Filter(it))
    }
    .map(goodsMapper::string2Goods)
}
