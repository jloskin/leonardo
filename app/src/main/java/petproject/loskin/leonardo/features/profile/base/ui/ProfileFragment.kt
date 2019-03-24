package petproject.loskin.leonardo.features.profile.base.ui

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.Screens
import petproject.loskin.leonardo.features.profile.DaggerProfileComponent
import petproject.loskin.leonardo.features.profile.Menu.BILLS
import petproject.loskin.leonardo.features.profile.Menu.EDIT
import petproject.loskin.leonardo.features.profile.Menu.FEEDBACK
import petproject.loskin.leonardo.features.profile.Menu.KONKURS
import petproject.loskin.leonardo.features.profile.Menu.MASTER_LIST
import petproject.loskin.leonardo.features.profile.Menu.MASTER_MKRATING
import petproject.loskin.leonardo.features.profile.Menu.MCLASSSUBSCRIBE
import petproject.loskin.leonardo.features.profile.Menu.ORDERS
import petproject.loskin.leonardo.features.profile.Menu.PROFILE
import petproject.loskin.leonardo.features.profile.Menu.REVIEWS
import petproject.loskin.leonardo.features.profile.Menu.TICKETS
import petproject.loskin.leonardo.features.profile.MenuType
import petproject.loskin.leonardo.features.profile.PersonalAreaAdapter
import petproject.loskin.leonardo.features.profile.base.presenters.ProfilePresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class ProfileFragment : RootFragment(), ProfileView {
    @Inject @InjectPresenter lateinit var presenter: ProfilePresenter
    @ProvidePresenter fun provide() = presenter

    init {
        DaggerProfileComponent.builder()
            .navigationModule(MainActivity.ROOT)
            .build()
            .inject(this)
    }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun titleId(): Int = R.string.profile

    private val adapter by lazy {
        PersonalAreaAdapter({
            when (it) {
                PROFILE -> router.navigateTo(Screens.Profile.MyProfile())
                EDIT -> router.navigateTo(Screens.Profile.Edit())
                KONKURS -> R.string.profile_konkurs
                FEEDBACK -> R.string.profile_feedback
                MASTER_LIST -> R.string.profile_master_list
                MASTER_MKRATING -> R.string.profile_master_mkrating
                ORDERS -> R.string.profile_orders
                TICKETS -> R.string.profile_tickets
                MCLASSSUBSCRIBE -> R.string.profile_mclasssubscribe
                REVIEWS -> R.string.profile_reviews
                BILLS -> R.string.profile_bills
            }
        })
    }

    override fun authorization(success: Boolean) {
        if (success) {
            adapter.update(MENUS)
            Utils.linearLayout(recyclerView, adapter)
        } else {
            router.newRootScreen(Screens.AuthorizeScreen())
        }
    }

    companion object {
        private val MENUS: Set<MenuType> = setOf(PROFILE, EDIT, KONKURS, FEEDBACK, MASTER_LIST,
            MASTER_MKRATING, ORDERS, TICKETS, MCLASSSUBSCRIBE, REVIEWS, BILLS)
    }
}