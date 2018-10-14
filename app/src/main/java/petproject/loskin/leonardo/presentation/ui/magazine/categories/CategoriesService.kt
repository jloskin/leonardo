package petproject.loskin.leonardo.presentation.ui.magazine.categories

import io.reactivex.Observable
import retrofit2.http.GET

interface CategoriesService {
    @GET("https://leonardohobby.ru/ishop/")
    fun loadGoodsCategories(): Observable<String>
}
