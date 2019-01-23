package music.lib.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.Toolbar
import music.lib.base.BaseActivity
import music.lib.core.R
import music.lib.core.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutId: Int = R.layout.activity_main

    override fun setupToolbar(): Toolbar? {
        return null
    }

    override fun setupViewModel(): MainViewModel {
        return ViewModelProviders
            .of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

}
