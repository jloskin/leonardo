package petproject.loskin.leonardo.data.network

import io.reactivex.Observable
import retrofit2.http.*

interface GetDataService {
    @GET("/")
    fun getAllPhotos(): Observable<String>

    @GET
    fun getUrl(@Url url: String): Observable<String>

    @GET
    fun getUrl(@Url url: String, @Query("pages") pages: Int): Observable<String>

    @GET("https://leonardo.ru/news")
    fun getNews(): Observable<String>

    @GET("https://leonardo.ru/competitions")
    fun getCompetitions(): Observable<String>

    @GET("https://leonardo.ru/mclasses")
    fun getMClasses(): Observable<String>

    @GET("https://leonardo.ru/recommends")
    fun leonardoRecommends(): Observable<String>

    @GET("https://leonardo.ru/articles")
    fun getArticles(): Observable<String>

    @GET("https://leonardohobby.ru/ishop/")
    fun loadGoodsCategories(): Observable<String>

    @FormUrlEncoded
    @POST("https://leonardohobby.ru/profile/")
    fun authorize(@Field("login") login: String, @Field("pass")  password: String): Observable<String>

    @GET("https://leonardohobby.ru/profile/orders/")
    fun orders(): Observable<String>
}