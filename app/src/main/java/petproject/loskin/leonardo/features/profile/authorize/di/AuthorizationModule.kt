package petproject.loskin.leonardo.features.profile.authorize.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.profile.ProfileService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class AuthorizationModule {
    @Provides
    fun service(
        retrofit: Retrofit
    ): ProfileService = retrofit.create(ProfileService::class.java)
}
