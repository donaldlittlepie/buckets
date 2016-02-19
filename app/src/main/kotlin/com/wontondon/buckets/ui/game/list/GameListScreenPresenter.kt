package com.wontondon.buckets.ui.game.list

import android.os.Bundle
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.game.edit.EditGameScreen
import com.wontondon.buckets.ui.game.view.ViewGameScreen
import flow.Flow
import mortar.ViewPresenter
import javax.inject.Inject

@DaggerScope(GameListScreen::class)
class GameListScreenPresenter @Inject constructor(
        val toolbarPresenter: ToolbarPresenter
) : ViewPresenter<GameListView>() {

    override fun onLoad(savedInstanceState: Bundle?) {
        super.onLoad(savedInstanceState)
        toolbarPresenter.setTitle("View Games")
    }

    fun addGameClicked() {
        Flow.get(view).set(EditGameScreen())
    }

    fun viewGameClicked() {
        Flow.get(view).set(ViewGameScreen())
    }
}