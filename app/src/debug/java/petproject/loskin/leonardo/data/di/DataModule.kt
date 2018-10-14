package petproject.loskin.leonardo.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
internal object DataModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideMoshi() = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Singleton
    @Provides
    @JvmStatic
    fun providesOkHttp(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

    @Singleton
    @Provides
    @JvmStatic
    fun provideRetrofit(oktHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
            .client(oktHttpClient)
            .baseUrl("https://api.github.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


//    @Singleton
//    @Provides
//    @JvmStatic
//    fun provideGitHubService(retrofit: Retrofit): GitHubService = retrofit.create(GitHubService::class.java)

}