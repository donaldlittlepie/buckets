package com.wontondon.buckets

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.wontondon.buckets.ui.ContextServices
import com.wontondon.buckets.ui.di.components.DaggerApplicationComponent
import com.wontondon.buckets.ui.di.modules.ApplicationModule
import mortar.MortarScope
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class BucketsApplication : Application() {

    private lateinit var applicationScope: MortarScope

    override fun onCreate() {
        super.onCreate()
        initializeMortar()
        initializeLogging()
        initializeLeakCanary()
    }

    private fun initializeLeakCanary() {
        LeakCanary.install(this)
    }

    private fun initializeLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
        else {
            // Configure a production logging option (i.e. Crashlytics)
        }
    }

    private fun initializeMortar() {
        Timber.d("Initializing Mortar root scope")

        val component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        // FIXME inject?
        this.applicationScope = MortarScope.buildRootScope()
                .withService(ContextServices.DAGGER_SERVICE, component)
                .build("Root")

        Timber.d("Mortar root scope initialized")
    }

    override fun getSystemService(name: String?): Any? {
        return if (applicationScope.hasService(name))
            applicationScope.getService(name)
        else
            super.getSystemService(name)
    }
}