package petproject.loskin.leonardo.domain.repositories.profile.authorize

import okhttp3.OkHttpClient
import petproject.loskin.leonardo.data.network.interceptor.AddCookiesInterceptor
import petproject.loskin.leonardo.data.network.interceptor.ReceivedCookiesInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

open class RetrofitRepository<T>(
  clazz: Class<T>,
  baseUrl: String = "https://leonardohobby.ru/",
  seconds: Long = 300
) {
  private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .client(
      OkHttpClient().newBuilder()
        .connectTimeout(seconds, TimeUnit.SECONDS)
        .readTimeout(seconds, TimeUnit.SECONDS)
        .writeTimeout(seconds, TimeUnit.SECONDS)
        .also {
          it.interceptors().addAll(listOf(
            ReceivedCookiesInterceptor(mutableSet),
            AddCookiesInterceptor(mutableSet)
          ))
        }
        .build()
    )
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

  val service: T = retrofit.create(clazz)

  companion object {
    private val mutableSet: MutableSet<String> = mutableSetOf()
  }
}