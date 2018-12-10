package petproject.loskin.leonardo.util.cicerone

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.Screen

abstract class SupportAppxScreen : Screen() {

  abstract val fragment: Fragment

  open fun getActivityIntent(context: Context): Intent? = null
}