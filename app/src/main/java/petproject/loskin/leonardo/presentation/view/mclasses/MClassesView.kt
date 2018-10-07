package petproject.loskin.leonardo.presentation.view.mclasses

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock
import petproject.loskin.leonardo.data.entity.news.NewsBlock

interface MClassesView : MvpView {

    fun updateMClasses(item: List<CompetitionsBlock>)

}
