package petproject.loskin.leonardo.base.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import petproject.loskin.leonardo.util.okhttp.interceptor.AddCookiesInterceptor
import petproject.loskin.leonardo.util.okhttp.interceptor.ReceivedCookiesInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
  @Provides
  fun retrofit(): Retrofit {
    val baseUrl = "https://leonardohobby.ru/"
    val seconds: Long = 300
    val mutableSet: MutableSet<String> = mutableSetOf(
      "PHPSESSID=l9oc1imkbdu3k6r5mhe8f9hk34; path=/"
    )

    return Retrofit.Builder()
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
  }
}
