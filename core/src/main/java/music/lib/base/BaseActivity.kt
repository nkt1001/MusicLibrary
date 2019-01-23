package music.lib.base

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.inputmethod.InputMethodManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel>: DaggerAppCompatActivity() {

    protected val lifecycleRegistry = LifecycleRegistry(this)

    protected lateinit var binding: BINDING
    protected lateinit var viewModel: VIEW_MODEL

    protected var toolbar: Toolbar? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    protected lateinit var prefs: SharedPreferences

    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)

        toolbar = setupToolbar()
        setSupportActionBar(toolbar)

        viewModel = setupViewModel()
    }

    protected fun showSnackbar(message: String) {
        if (message.isNotEmpty()) {
            Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
        }
    }

    protected fun hideSoftKeyBoard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if (imm.isAcceptingText) {
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        currentFocus?.clearFocus()
    }

    abstract fun setupToolbar(): Toolbar?

    abstract fun setupViewModel(): VIEW_MODEL

}