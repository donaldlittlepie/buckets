package com.wontondon.buckets.ui.di

import javax.inject.Scope
import kotlin.reflect.KClass

/**
 * Dagger scope annotation
 */
@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class DaggerScope(val value: KClass<*>)
