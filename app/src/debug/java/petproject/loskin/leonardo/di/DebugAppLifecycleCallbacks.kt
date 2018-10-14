package petproject.loskin.leonardo.di

import android.app.Application
import petproject.loskin.leonardo.AppLifecycleCallbacks
import timber.log.Timber

class DebugAppLifecycleCallbacks : AppLifecycleCallbacks {

  override fun onCreate(application: Application) {
    Timber.plant(Timber.DebugTree())
  }

  override fun onTerminate(application: Application) {

  }
}
