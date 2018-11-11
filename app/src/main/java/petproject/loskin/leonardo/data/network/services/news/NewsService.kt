package petproject.loskin.leonardo.data.network.services.news

import io.reactivex.Observable
import retrofit2.http.GET

interface NewsService {
    @GET("https://leonardo.ru/news")
    fun news(): Observable<String>

    @GET("https://leonardo.ru/competitions")
    fun competitions(): Observable<String>

    @GET("https://leonardo.ru/mclasses")
    fun mClasses(): Observable<String>

    @GET("https://leonardo.ru/articles")
    fun articles(): Observable<String>
}