package petproject.loskin.leonardo.data.network.services.profile

import io.reactivex.Observable
import retrofit2.http.GET

interface ProfileService {
  @GET("/profile/")
  fun profile(): Observable<String>

  @GET("/profile/edit/")
  fun edit(): Observable<String>

  @GET("/profile/konkurs/")
  fun konkurs(): Observable<String>

  @GET("/profile/feedback/")
  fun feedback(): Observable<String>

  @GET("/profile/master/list/")
  fun list(): Observable<String>

  @GET("/profile/master/mkrating/")
  fun mkrating(): Observable<String>

  @GET("/profile/orders/")
  fun orders(): Observable<String>

  @GET("/profile/ticket/")
  fun ticket(): Observable<String>

  @GET("/profile/reviews/")
  fun reviews(): Observable<String>
}