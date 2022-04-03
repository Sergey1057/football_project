package ru.sergey1057.scorers.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.sergey1057.scorers.viewmodel.ScorersViewModelFactory
import ru.sergey1057.scorers.webApi.WebApi

@Module
interface ScorersModule {

    @Binds
    fun bindsScorersViewModelFactory(scorersViewModelFactory: ScorersViewModelFactory): ViewModelProvider.Factory

    companion object {
        @Provides
        fun provideWebApi(retrofit: Retrofit): WebApi {
            return retrofit.create(WebApi::class.java)
        }
    }
}