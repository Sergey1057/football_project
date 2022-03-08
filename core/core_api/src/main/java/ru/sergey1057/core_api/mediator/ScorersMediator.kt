package ru.sergey1057.core_api.mediator

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface ScorersMediator {
    fun startScorersScreen(@IdRes containerId: Int, fragmentManager: FragmentManager)
}