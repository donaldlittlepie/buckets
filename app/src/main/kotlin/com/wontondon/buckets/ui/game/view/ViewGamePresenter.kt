package com.wontondon.buckets.ui.game.view

import android.os.Bundle
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.game.edit.EditGameScreen
import com.wontondon.buckets.ui.game.score.ScoreGameScreen
import flow.Flow
import mortar.ViewPresenter
import javax.inject.Inject

@DaggerScope(ViewGameScreen::class)
class ViewGamePresenter @Inject constructor(
        val toolbarPresenter: ToolbarPresenter
) : ViewPresenter<ViewGameView>() {

    override fun onLoad(savedInstanceState: Bundle?) {
        super.onLoad(savedInstanceState)
        toolbarPresenter.setTitle("View Game")
    }

    fun editGameClicked() {
        Flow.get(view).set(EditGameScreen(gameId = 1))
    }


    fun scoreGameClicked() {
        Flow.get(view).set(ScoreGameScreen())
    }
}