package com.wontondon.buckets.ui.di.components

import com.wontondon.buckets.ui.di.modules.ApplicationModule
import com.wontondon.buckets.ui.game.edit.EditGameScreen.EditGameScreenComponent
import com.wontondon.buckets.ui.game.edit.EditGameScreen.EditGameScreenModule
import com.wontondon.buckets.ui.game.list.GameListScreen.GameListScreenComponent
import com.wontondon.buckets.ui.game.list.GameListScreen.GameListScreenModule
import com.wontondon.buckets.ui.game.view.ViewGameScreen.ViewGameScreenComponent
import com.wontondon.buckets.ui.game.view.ViewGameScreen.ViewGameScreenModule
import com.wontondon.buckets.ui.player.edit.EditPlayerScreen.EditPlayerScreenComponent
import com.wontondon.buckets.ui.player.edit.EditPlayerScreen.EditPlayerScreenModule
import com.wontondon.buckets.ui.player.list.PlayerListScreen.PlayerListScreenComponent
import com.wontondon.buckets.ui.player.list.PlayerListScreen.PlayerListScreenModule
import com.wontondon.buckets.ui.player.view.ViewPlayerScreen.ViewPlayerScreenComponent
import com.wontondon.buckets.ui.player.view.ViewPlayerScreen.ViewPlayerScreenModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun plus(module: PlayerListScreenModule) : PlayerListScreenComponent
    fun plus(module: EditPlayerScreenModule) : EditPlayerScreenComponent
    fun plus(module: EditGameScreenModule): EditGameScreenComponent
    fun plus(module: ViewGameScreenModule): ViewGameScreenComponent
    fun plus(module: GameListScreenModule): GameListScreenComponent
    fun plus(module: ViewPlayerScreenModule): ViewPlayerScreenComponent
}