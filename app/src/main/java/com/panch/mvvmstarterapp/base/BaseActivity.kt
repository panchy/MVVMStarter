package com.panch.mvvmstarterapp.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panch.mvvmstarterapp.ui.main.listFragment.ListFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {
    protected abstract val layoutRes: Int

    protected abstract fun onCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutRes)
        onCreated()
    }

    //This is called for Calligraphy library. Font overriding.
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}