package petproject.loskin.leonardo.presentation.view.competitions

import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock

interface CompetitionsView {
    fun updateCompetitions(conpetitions: List<CompetitionsBlock>)
}