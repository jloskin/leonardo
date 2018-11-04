package petproject.loskin.leonardo.data.network.magazine.categories

import io.reactivex.Flowable
import retrofit2.http.GET

interface CategoriesService {
    @GET("https://leonardohobby.ru/ishop/")
    fun initMenu(): Flowable<String>
}
