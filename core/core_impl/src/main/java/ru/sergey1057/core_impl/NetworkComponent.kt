package ru.sergey1057.core_impl

import dagger.Component
import ru.sergey1057.core_api.network.NetworkProvider
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent : NetworkProvider