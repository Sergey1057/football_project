package ru.sergey1057.scorers

import androidx.fragment.app.FragmentManager
import ru.sergey1057.core_api.mediator.ScorersMediator
import javax.inject.Inject

class ScorersMediatorImpl
@Inject constructor() : ScorersMediator {

    override fun startScorersScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(containerId, ScorersFragment.newInstance())
            .commit()
    }
}