package ru.sergey1057.scorers.di

import dagger.Component
import ru.sergey1057.core_api.mediator.ProvidersFacade
import ru.sergey1057.scorers.ScorersFragment
import javax.inject.Singleton


@Singleton
@Component(
    modules = [ScorersModule::class],
    dependencies = [ProvidersFacade::class]
)
interface ScorersComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): ScorersComponent {
            return DaggerScorersComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(scorersFragment: ScorersFragment)
}