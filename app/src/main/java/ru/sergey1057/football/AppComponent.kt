package ru.sergey1057.football

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.BindsInstance
import ru.sergey1057.core_api.mediator.AppProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent : AppProvider {

    companion object {

        private var appComponent: AppProvider? = null

        fun create(application: Application): AppProvider {
            return appComponent ?: DaggerAppComponent
                .builder()
                .application(application.applicationContext)
                .build().also {
                    appComponent = it
                }
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }
}