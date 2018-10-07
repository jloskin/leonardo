package petproject.loskin.leonardo.presentation.view.competitions

import com.arellomobile.mvp.MvpView
import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock

interface CompetitionsView : MvpView {
    fun updateCompetitions(conpetitions: List<CompetitionsBlock>)
}