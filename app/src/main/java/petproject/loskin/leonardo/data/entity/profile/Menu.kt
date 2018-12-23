package petproject.loskin.leonardo.data.entity.profile

import androidx.annotation.IntDef
import androidx.annotation.StringRes
import petproject.loskin.leonardo.R

typealias MenuType = Int

object Menu {
  @StringRes
  fun value(@Type type: MenuType): Int = when (type) {
    PROFILE -> R.string.profile_profile
    EDIT -> R.string.profile_edit
    KONKURS -> R.string.profile_konkurs
    FEEDBACK -> R.string.profile_feedback
    MASTER_LIST -> R.string.profile_master_list
    MASTER_MKRATING -> R.string.profile_master_mkrating
    ORDERS -> R.string.profile_orders
    TICKETS -> R.string.profile_tickets
    MCLASSSUBSCRIBE -> R.string.profile_mclasssubscribe
    REVIEWS -> R.string.profile_reviews
    BILLS -> R.string.profile_bills
    else -> throw RuntimeException()
  }

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