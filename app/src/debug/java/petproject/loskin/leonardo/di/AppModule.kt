package petproject.loskin.leonardo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.App
import petproject.loskin.leonardo.AppLifecycleCallbacks
import petproject.loskin.leonardo.data.db.AppDatabase
import petproject.loskin.leonardo.data.di.DataModule
import petproject.loskin.leonardo.data.entity.magazine.CategoriesDao
import javax.inject.Singleton

@Module(includes = [DataModule::class])
internal object AppModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = DebugAppLifecycleCallbacks()

    @Singleton
    @Provides
    @JvmStatic
    fun provideCategoriesDao(context: App): CategoriesDao = AppDatabase.getInstance(context).categoriesDao()
}