package petproject.loskin.leonardo.features.news.articles.services

import io.reactivex.Observable
import retrofit2.http.GET

interface ArticlesService {
  @GET("/articles/")
  fun articles(): Observable<String>
}