package ru.sergey1057.football

import android.app.Application
import dagger.Component
import ru.sergey1057.core.CoreProvidersFactory
import ru.sergey1057.core_api.mediator.AppProvider
import ru.sergey1057.core_api.mediator.ProvidersFacade
import ru.sergey1057.core_api.network.NetworkProvider

@Component(
    dependencies = [AppProvider::class, NetworkProvider::class],
    modules = [MediatorsBindings::class]
)
interface FacadeComponent : ProvidersFacade {

    companion object {

        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .networkProvider(CoreProvidersFactory.createRetrofit())
                .build()
    }

    fun inject(app: App)
}