package ru.sergey1057.home

import androidx.fragment.app.FragmentManager
import ru.sergey1057.core_api.mediator.HomeMediator
import javax.inject.Inject

class HomeMediatorImpl
@Inject constructor() : HomeMediator {

    override fun startHomeScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(containerId, HomeFragment.newInstance())
            .commit()
    }
}