package petproject.loskin.leonardo.features.shop.goods.services

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GoodsService {
    @GET("/ishop/{tree}")
    fun goods(@Path("tree") tree: String): Observable<String>
}
