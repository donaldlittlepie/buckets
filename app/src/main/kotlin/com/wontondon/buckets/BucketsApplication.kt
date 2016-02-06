package com.wontondon.buckets

import android.app.Application
import com.wontondon.buckets.presentation.di.components.ApplicationComponent
import com.wontondon.buckets.presentation.di.components.DaggerApplicationComponent
import com.wontondon.buckets.presentation.di.modules.ApplicationModule

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class BucketsApplication : Application() {

    private lateinit var component: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()

        this.component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}