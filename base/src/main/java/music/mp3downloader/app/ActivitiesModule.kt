package music.mp3downloader.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import music.mp3downloader.ui.MainActivity

@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}