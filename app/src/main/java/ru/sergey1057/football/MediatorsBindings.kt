package ru.sergey1057.football

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.sergey1057.core_api.mediator.*
import ru.sergey1057.home.HomeMediatorImpl
import ru.sergey1057.main.navigation.MainMediatorImpl
import ru.sergey1057.scorers.ScorersMediatorImpl
import ru.sergey1057.world.WorldMediatorImpl

@Module
interface MediatorsBindings {

    @Binds
    @Reusable
    fun bindsMainMediator(mainMediatorImpl: MainMediatorImpl): MainMediator

    @Binds
    @Reusable
    fun bindsHomeMediator(homeMediatorImpl: HomeMediatorImpl): HomeMediator

    @Binds
    @Reusable
    fun bindsScorersMediator(scorersMediatorImpl: ScorersMediatorImpl): ScorersMediator

    @Binds
    @Reusable
    fun bindsWorldMediator(worldMediatorImpl: WorldMediatorImpl): WorldMediator
}