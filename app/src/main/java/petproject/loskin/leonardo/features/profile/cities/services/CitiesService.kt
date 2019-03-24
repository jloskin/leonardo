package petproject.loskin.leonardo.features.profile.cities.services

import io.reactivex.Flowable
import retrofit2.http.GET

interface CitiesService {
    @GET("/ajax/city.php")
    fun cities(): Flowable<String>
}