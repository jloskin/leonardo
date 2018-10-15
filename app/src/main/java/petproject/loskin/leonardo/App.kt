package petproject.loskin.leonardo

import android.app.Application
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin context
        startKoin(this, listOf(appModule))
    }
}
