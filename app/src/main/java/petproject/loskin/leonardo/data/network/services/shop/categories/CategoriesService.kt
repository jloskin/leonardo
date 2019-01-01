package petproject.loskin.leonardo.data.network.services.shop.categories

import io.reactivex.Flowable
import retrofit2.http.GET

interface CategoriesService {
  @GET("/ishop/")
  fun menus(): Flowable<String>

  @GET("/ajax/city.php")
  fun cities(): Flowable<String>
}
