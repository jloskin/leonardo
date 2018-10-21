package petproject.loskin.leonardo.presentation.view.news.competitions

import petproject.loskin.leonardo.data.entity.news.competitions.CompetitionsBlock

interface CompetitionsView {
    fun updateCompetitions(conpetitions: List<CompetitionsBlock>)
}