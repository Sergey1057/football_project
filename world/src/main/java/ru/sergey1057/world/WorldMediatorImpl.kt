package ru.sergey1057.world

import androidx.fragment.app.FragmentManager
import ru.sergey1057.core_api.mediator.ScorersMediator
import ru.sergey1057.core_api.mediator.WorldMediator
import javax.inject.Inject

class WorldMediatorImpl
@Inject constructor() : WorldMediator {

    override fun startWorldScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(containerId, WorldFragment.newInstance())
            .commit()
    }
}