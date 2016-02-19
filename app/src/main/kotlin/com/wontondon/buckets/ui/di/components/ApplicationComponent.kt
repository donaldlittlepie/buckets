package com.wontondon.buckets.ui.di.components

import com.wontondon.buckets.ui.di.modules.ApplicationModule
import com.wontondon.buckets.ui.player.edit.EditPlayerScreen
import com.wontondon.buckets.ui.player.list.PlayerListScreen
import dagger.Component
import javax.inject.Singleton

/**
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun plus(module: PlayerListScreen.Module) : PlayerListScreen.PlayerListScreenComponent
    fun plus(module: EditPlayerScreen.Module) : EditPlayerScreen.EditPlayerScreenComponent

}