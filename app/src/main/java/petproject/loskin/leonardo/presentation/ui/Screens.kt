package petproject.loskin.leonardo.presentation.ui

import petproject.loskin.leonardo.presentation.ui.articles.ArticlesFragment
import petproject.loskin.leonardo.presentation.ui.competitions.fragment.CompetitionsFragment
import petproject.loskin.leonardo.presentation.ui.magazine.MagazineFragment
import petproject.loskin.leonardo.presentation.ui.main.PersonFragment
import petproject.loskin.leonardo.presentation.ui.mclasses.MClassesFragment
import petproject.loskin.leonardo.presentation.ui.news.NewsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    class Magazine : SupportAppScreen() {
        override fun getFragment() = MagazineFragment()
    }

    class AllNews : SupportAppScreen() {
        override fun getFragment() = AllNewsFragment()
    }

    class News : SupportAppScreen() {
        override fun getFragment() = NewsFragment()
    }

    class Person : SupportAppScreen() {
        override fun getFragment() = PersonFragment()
    }

    class Competitions : SupportAppScreen() {
        override fun getFragment() = CompetitionsFragment()
    }

    class MClasses : SupportAppScreen() {
        override fun getFragment() = MClassesFragment()
    }

    class Articles : SupportAppScreen() {
        override fun getFragment() = ArticlesFragment()
    }
}