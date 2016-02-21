package com.wontondon.buckets

import android.app.Application
import android.util.Log
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.squareup.leakcanary.LeakCanary
import com.wontondon.buckets.ui.ContextServices
import com.wontondon.buckets.ui.di.components.DaggerApplicationComponent
import com.wontondon.buckets.ui.di.modules.ApplicationModule
import io.fabric.sdk.android.Fabric
import mortar.MortarScope
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Buckets application.
 */
class BucketsApplication : Application() {

    private lateinit var applicationScope: MortarScope

    override fun onCreate() {
        super.onCreate()
        initializeLogging()
        initializeCrashlytics()
        initializeMortar()
        initializeLeakCanary()
    }

    private fun initializeCrashlytics() {
        Timber.v("Initializing Crashlytics")
        val core = CrashlyticsCore.Builder()
            .disabled(BuildConfig.DEBUG)
            .build()

        Fabric.with(this, Crashlytics.Builder().core(core).build())

        Timber.v("Planting Crashlytics tree")
        Timber.plant(CrashlyticsTree())
    }

    private fun initializeLeakCanary() {
        Timber.v("Initializing LeakCanary")
        LeakCanary.install(this)
    }

    private fun initializeLogging() {
        Timber.v("Initializing Logging")
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    private fun initializeMortar() {
        Timber.v("Initializing Mortar root scope")

        val component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

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

/**
 * Log warnings and exceptions to Crashlytics.
 */
class CrashlyticsTree : Timber.Tree() {
    private companion object {
        private const val CRASHLYTICS_KEY_PRIORITY = "priority"
        private const val CRASHLYTICS_KEY_TAG = "tag"
        private const val CRASHLYTICS_KEY_MESSAGE = "message"
    }

    override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }

        Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority)
        Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag)
        Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message)

        if (t == null) {
            Crashlytics.logException(Exception(message))
        }
        else {
            Crashlytics.logException(t)
        }
    }

}