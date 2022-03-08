package ru.sergey1057.world.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.sergey1057.world.viewmodel.WorldViewModelFactory
import ru.sergey1057.world.webApi.WebApi

@Module
interface WorldModule {

    @Binds
    fun bindsWorldViewModelFactory(worldViewModelFactory: WorldViewModelFactory): ViewModelProvider.Factory

    companion object {
        @Provides
        fun provideWebApi(retrofit: Retrofit): WebApi {
            return retrofit.create(WebApi::class.java)
        }
    }
}