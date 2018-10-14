package petproject.loskin.leonardo

import android.app.Application

interface AppLifecycleCallbacks {

  fun onCreate(application: Application)

  fun onTerminate(application: Application)
}