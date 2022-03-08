package ru.sergey1057.core_api.mediator

import android.content.Context

interface AppProvider {

    fun provideContext(): Context
}