package com.wontondon.buckets.ui.player.view

import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.game.edit.EditGameScreen
import com.wontondon.buckets.ui.game.list.GameListScreen
import com.wontondon.buckets.ui.player.edit.EditPlayerScreen
import flow.Flow
import mortar.ViewPresenter
import javax.inject.Inject

@DaggerScope(ViewPlayerScreen::class)
class ViewPlayerScreenPresenter @Inject constructor() : ViewPresenter<ViewPlayerView>() {


    fun addGameClicked() {
        Flow.get(view).set(EditGameScreen())
    }

    fun viewGameListClicked() {
        Flow.get(view).set(GameListScreen())
    }

    fun onEditPlayerClicked() {
        Flow.get(view).set(EditPlayerScreen(playerId = 1))
    }
}