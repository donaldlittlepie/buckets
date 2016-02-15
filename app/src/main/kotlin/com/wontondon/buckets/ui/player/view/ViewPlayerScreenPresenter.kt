package com.wontondon.buckets.ui.player.view

import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.game.edit.EditGameScreen
import com.wontondon.buckets.ui.game.list.GameListScreen
import flow.Flow
import mortar.ViewPresenter
import timber.log.Timber
import javax.inject.Inject

@DaggerScope(ViewPlayerScreen::class)
class ViewPlayerScreenPresenter : ViewPresenter<ViewPlayerView> {
    @Inject constructor() {
        Timber.d("Creating %s", ViewPlayerScreenPresenter::class.java.simpleName)
    }

    fun addGameClicked() {
        Flow.get(view).set(EditGameScreen())
    }

    fun viewGameListClicked() {
        Flow.get(view).set(GameListScreen())
    }
}