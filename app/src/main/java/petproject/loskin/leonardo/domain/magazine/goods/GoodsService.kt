package petproject.loskin.leonardo.domain.magazine.goods

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface GoodsService {
    @GET
    fun getUrl(@Url url: String): Observable<String>
}
