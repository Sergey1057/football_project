package ru.sergey1057.main.di

import dagger.Component
import ru.sergey1057.core_api.mediator.ProvidersFacade
import ru.sergey1057.main.MainActivity


@Component(
    dependencies = [ProvidersFacade::class]
)
interface MainComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): MainComponent {
            return DaggerMainComponent.builder().providersFacade(providersFacade).build()
        }
    }

    fun inject(mainActivity: MainActivity)
}