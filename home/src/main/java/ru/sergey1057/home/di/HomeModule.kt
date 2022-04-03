package ru.sergey1057.home.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.sergey1057.home.viewmodel.HomeViewModelFactory
import ru.sergey1057.home.webApi.WebApi
import javax.inject.Singleton

@Module
interface HomeModule {

    @Binds
    fun bindsHomeViewModelFactory(homeViewModelFactory: HomeViewModelFactory): ViewModelProvider.Factory

    companion object {
        @Provides
        fun provideWebApi(retrofit: Retrofit): WebApi {
            return retrofit.create(WebApi::class.java)
        }
    }
}