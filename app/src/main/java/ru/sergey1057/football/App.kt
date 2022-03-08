package ru.sergey1057.football

import android.app.Application
import ru.sergey1057.core_api.mediator.AppWithFacade
import ru.sergey1057.core_api.mediator.ProvidersFacade

class App : Application(), AppWithFacade {

    companion object {

        private var facadeComponent: FacadeComponent? = null
    }

    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }
}