package music.lib

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import music.lib.app.ActivitiesModule
import music.lib.app.AppModule
import music.lib.dependencies.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ActivitiesModule::class,
    AppModule::class,
    ViewModelModule::class]
)
interface AppComponent: AndroidInjector<PlayerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: Application): Builder

        fun build(): AppComponent
    }
}