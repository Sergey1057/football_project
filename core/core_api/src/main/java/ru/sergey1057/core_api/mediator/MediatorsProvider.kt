package ru.sergey1057.core_api.mediator

interface MediatorsProvider {

    fun provideMainMediator(): MainMediator

    fun provideHomeMediator(): HomeMediator

    fun provideScorersMediator(): ScorersMediator

    fun provideWorldMediator(): WorldMediator

}