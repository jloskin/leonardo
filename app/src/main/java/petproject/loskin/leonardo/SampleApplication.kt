package petproject.loskin.leonardo

import android.app.Application

import petproject.loskin.leonardo.di.AppComponent
import petproject.loskin.leonardo.di.DaggerAppComponent

class SampleApplication : Application() {
    val appComponent: AppComponent by lazy { DaggerAppComponent.builder().build() }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: SampleApplication
    }
}
