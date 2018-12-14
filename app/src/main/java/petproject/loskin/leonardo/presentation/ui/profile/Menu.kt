package petproject.loskin.leonardo.presentation.ui.profile

import androidx.annotation.IntDef

typealias Menu = Int

@Retention(AnnotationRetention.SOURCE)
@IntDef(Const.PROFILE, Const.EDIT, Const.KONKURS, Const.FEEDBACK, Const.MASTER_LIST, Const.MASTER_MKRATING, Const.ORDERS, Const.TICKETS, Const.MCLASSSUBSCRIBE, Const.REVIEWS, Const.BILLS)
annotation class MenuType

object Const {
  const val PROFILE: Int = 0
  const val EDIT: Int = 1
  const val KONKURS: Int = 2
  const val FEEDBACK: Int = 3
  const val MASTER_LIST: Int = 4
  const val MASTER_MKRATING: Int = 5
  const val ORDERS: Int = 6
  const val TICKETS: Int = 7
  const val MCLASSSUBSCRIBE: Int = 8
  const val REVIEWS: Int = 9
  const val BILLS: Int = 10
}