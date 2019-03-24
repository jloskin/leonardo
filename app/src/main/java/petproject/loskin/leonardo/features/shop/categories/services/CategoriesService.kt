package petproject.loskin.leonardo.features.shop.categories.services

import io.reactivex.Flowable
import retrofit2.http.GET

interface CategoriesService {
    @GET("/ishop/")
    fun menus(): Flowable<String>
}
