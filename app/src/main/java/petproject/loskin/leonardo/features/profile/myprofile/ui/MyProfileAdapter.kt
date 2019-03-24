package petproject.loskin.leonardo.features.profile.myprofile.ui

import android.view.View
import kotlinx.android.synthetic.main.my_profile_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.features.profile.myprofile.models.ProfileData
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder

class MyProfileAdapter : BaseRecyclerAdapter<ProfileData, MyProfileAdapter.Holder>() {
    override fun item(itemView: View): Holder = Holder(itemView)

    override fun getItemViewType(position: Int) = R.layout.my_profile_cell

    class Holder(itemView: View) : BaseRecyclerViewHolder<ProfileData>(itemView) {
        override fun bind(item: ProfileData) {
            with(itemView) {
                field.text = item.field
                value.text = item.value
            }
        }
    }
}
