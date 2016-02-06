package com.wontondon.buckets

import android.app.Application
import com.wontondon.buckets.presentation.di.components.ApplicationComponent
import com.wontondon.buckets.presentation.di.components.DaggerApplicationComponent
import com.wontondon.buckets.presentation.di.modules.ApplicationModule
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class BucketsApplication : Application() {

    private lateinit var component: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        initializeLogging()
        initializeDagger()
    }

    private fun initializeLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
        else {
            // Configure a production logging option (i.e. Crashlytics)
        }
    }

    private fun initializeDagger() {
        Timber.d("Initializing Dagger ApplicationComponent")

        this.component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        Timber.d("Dagger ApplicationComponent initialized")
    }


}