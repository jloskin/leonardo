package petproject.loskin.leonardo.data.network.services.news

import io.reactivex.Observable
import retrofit2.http.GET

interface NewsService {
  @GET("/news/")
  fun news(): Observable<String>

  @GET("/competitions/")
  fun competitions(): Observable<String>

  @GET("/mclasses/")
  fun mClasses(): Observable<String>

  @GET("/articles/")
  fun articles(): Observable<String>
}