package com.wontondon.buckets.presentation.di.modules

import android.content.Context
import com.wontondon.buckets.BucketsApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
@Module
class ApplicationModule(private val application: BucketsApplication) {

    @Provides @Singleton fun applicationContext(): Context = application
}