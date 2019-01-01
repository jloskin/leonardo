package petproject.loskin.leonardo.domain.repositories.shop

import io.reactivex.Flowable
import io.reactivex.Observable
import petproject.loskin.leonardo.data.db.dao.magazine.categories.ShopDao
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.data.entity.shop.goods.GoodsData
import petproject.loskin.leonardo.data.mapper.shop.goods.GoodsMapper
import petproject.loskin.leonardo.data.network.services.shop.goods.GoodsService
import petproject.loskin.leonardo.data.entity.shop.goods.Filter

class GoodsRepository(
  private val shopDao: ShopDao,
  private val goodsMapper: GoodsMapper,
  private val service: GoodsService
) {
  val filters: MutableList<Filter> = mutableListOf()

  fun chips(item: String): Flowable<List<MenuL>> = shopDao.menus(item)

  fun getGoods(item: String, page: String = ""): Observable<List<GoodsData>> = service.goods(item)
    .doOnNext {
      if (filters.isEmpty())
        filters.addAll(goodsMapper.string2Filter(it))
    }
    .map(goodsMapper::string2Goods)
}
