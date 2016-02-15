package com.wontondon.buckets.ui.game.list

import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.game.edit.EditGameScreen
import com.wontondon.buckets.ui.game.view.ViewGameScreen
import flow.Flow
import mortar.ViewPresenter
import timber.log.Timber
import javax.inject.Inject

@DaggerScope(GameListScreen::class)
class GameListScreenPresenter : ViewPresenter<GameListView> {
    @Inject constructor() {
        Timber.d("Creating %s", GameListScreenPresenter::class.java.simpleName)
    }

    fun addGameClicked() {
        Flow.get(view).set(EditGameScreen())
    }

    fun viewGameClicked() {
        Flow.get(view).set(ViewGameScreen())
    }
}