package petproject.loskin.leonardo.features.profile.base.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.profile.base.services.ProfileService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class ProfileModule {
    @Provides
    fun provide(
        retrofit: Retrofit
    ): ProfileService = retrofit.create(ProfileService::class.java)
}
