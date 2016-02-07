package com.wontondon.buckets.ui.di.components

import android.app.Activity
import com.wontondon.buckets.ui.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(activity: Activity)
}