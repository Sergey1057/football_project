package ru.sergey1057.core_api.mediator

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager


interface HomeMediator {

    fun startHomeScreen(@IdRes containerId: Int, fragmentManager: FragmentManager)
}