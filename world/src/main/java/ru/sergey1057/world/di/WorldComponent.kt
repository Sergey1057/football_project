package ru.sergey1057.world.di

import dagger.Component
import ru.sergey1057.core_api.mediator.ProvidersFacade
import ru.sergey1057.world.WorldFragment
import javax.inject.Singleton


@Singleton
@Component(
    modules = [WorldModule::class],
    dependencies = [ProvidersFacade::class]
)
interface WorldComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): WorldComponent {
            return DaggerWorldComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(worldFragment: WorldFragment)
}