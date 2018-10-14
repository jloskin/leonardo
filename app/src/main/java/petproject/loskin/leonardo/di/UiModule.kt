package petproject.loskin.leonardo.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import petproject.loskin.leonardo.di.module.MainModule
import petproject.loskin.leonardo.presentation.ui.main.MainActivity

@Module
internal abstract class UiModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

}