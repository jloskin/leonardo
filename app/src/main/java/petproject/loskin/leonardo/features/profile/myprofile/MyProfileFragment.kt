package petproject.loskin.leonardo.features.profile.myprofile

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class MyProfileFragment : RootFragment(), MyProfileView {
    @Inject @InjectPresenter lateinit var presenter: MyProfilePresenter
    @ProvidePresenter fun provide() = presenter

    private val adapter by lazy { MyProfileAdapter() }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun titleId(): Int = R.string.profile_profile

    override fun update(items: List<ProfileData>) {
        Utils.defaultList(recyclerView, adapter)
        adapter.update(items)
    }
}
