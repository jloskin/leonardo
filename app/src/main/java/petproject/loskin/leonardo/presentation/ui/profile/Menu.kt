package petproject.loskin.leonardo.presentation.ui.profile

import androidx.annotation.IntDef

typealias MenuType = Int

object Menu {
  @Retention(AnnotationRetention.SOURCE)
  @IntDef(PROFILE, EDIT, KONKURS, FEEDBACK, MASTER_LIST, MASTER_MKRATING, ORDERS, TICKETS, MCLASSSUBSCRIBE, REVIEWS, BILLS)
  annotation class Type

  const val PROFILE: MenuType = 0
  const val EDIT: MenuType = 1
  const val KONKURS: MenuType = 2
  const val FEEDBACK: MenuType = 3
  const val MASTER_LIST: MenuType = 4
  const val MASTER_MKRATING: MenuType = 5
  const val ORDERS: MenuType = 6
  const val TICKETS: MenuType = 7
  const val MCLASSSUBSCRIBE: MenuType = 8
  const val REVIEWS: MenuType = 9
  const val BILLS: MenuType = 10
}