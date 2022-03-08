package ru.sergey1057.core

import ru.sergey1057.core_api.network.NetworkProvider
import ru.sergey1057.core_impl.DaggerNetworkComponent

object CoreProvidersFactory {

    fun createRetrofit(): NetworkProvider{
        return DaggerNetworkComponent.create()
    }
}