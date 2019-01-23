package music.lib

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class PlayerApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.builder().app(this).build()
}