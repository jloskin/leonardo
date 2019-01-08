package petproject.loskin.leonardo.data.network.services.profile.authorization

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ProfileService {
  @FormUrlEncoded
  @POST("/profile/")
  fun authorize(@Field("login") login: String, @Field("pass") password: String): Observable<String>
}
