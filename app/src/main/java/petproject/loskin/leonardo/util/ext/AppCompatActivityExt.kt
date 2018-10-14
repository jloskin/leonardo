package petproject.loskin.leonardo.util.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

inline fun FragmentActivity.setContentFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
  val manager = supportFragmentManager
  val fragment = manager?.findFragmentById(containerViewId)
  fragment?.let { return it }
  return f().apply { manager?.beginTransaction()?.add(containerViewId, this)?.commit() }
}