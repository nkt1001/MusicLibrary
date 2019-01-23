package music.lib.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import music.lib.ui.MainActivity

@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}