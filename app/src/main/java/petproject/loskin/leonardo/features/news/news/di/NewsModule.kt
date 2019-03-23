package petproject.loskin.leonardo.features.news.news.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.news.news.services.NewsService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class NewsModule {
  @Provides
  fun service(
    retrofit: Retrofit
  ): NewsService = retrofit.create(NewsService::class.java)
}
