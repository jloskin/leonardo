package petproject.loskin.leonardo.data.network.services.shop.goods

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GoodsService {
  @GET("/ishop/{tree}")
  fun goods(@Path("tree") tree: String): Observable<String>
}
