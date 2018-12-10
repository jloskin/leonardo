package petproject.loskin.leonardo

import android.app.Application
import org.koin.android.ext.android.startKoin
import petproject.loskin.leonardo.di.appModule

class App : Application() {
  init {
    startKoin(this, listOf(appModule))
  }
}