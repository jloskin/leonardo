package petproject.loskin.leonardo.features.news.news.services

import io.reactivex.Observable
import retrofit2.http.GET

interface NewsService {
    @GET("/news/")
    fun news(): Observable<String>
}