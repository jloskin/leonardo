package petproject.loskin.leonardo.data.network

import okhttp3.OkHttpClient
import petproject.loskin.leonardo.data.network.interceptor.AddCookiesInterceptor
import petproject.loskin.leonardo.data.network.interceptor.ReceivedCookiesInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClientInstance {
    val retrofit: Retrofit by lazy {
        val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout((60 * 5).toLong(), TimeUnit.SECONDS)
                .readTimeout((60 * 5).toLong(), TimeUnit.SECONDS)
                .writeTimeout((60 * 5).toLong(), TimeUnit.SECONDS)
        okHttpClient.interceptors().add(AddCookiesInterceptor())
        okHttpClient.interceptors().add(ReceivedCookiesInterceptor())

        retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
    private const val BASE_URL = "https://leonardohobby.ru/ishop/"
}