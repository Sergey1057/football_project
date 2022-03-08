package ru.sergey1057.home.di

import dagger.Component
import ru.sergey1057.core_api.mediator.ProvidersFacade
import ru.sergey1057.home.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [HomeModule::class],
    dependencies = [ProvidersFacade::class]
)
interface HomeComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): HomeComponent {
            return DaggerHomeComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(homeFragment: HomeFragment)
}