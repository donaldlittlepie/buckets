package com.wontondon.buckets.ui.game.edit

import android.os.Bundle
import com.wontondon.buckets.domain.Game
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import flow.Flow
import mortar.ViewPresenter
import javax.inject.Inject

@DaggerScope(EditGameScreen::class)
class EditGameScreenPresenter @Inject constructor(
        val game: Game?,
        val toolbarPresenter: ToolbarPresenter
) : ViewPresenter<EditGameView>() {

    override fun onLoad(savedInstanceState: Bundle?) {
        if (game == null) {
            toolbarPresenter.setTitle("Add Game")
        }
        else {
            toolbarPresenter.setTitle("Edit Game")
        }
    }

    fun saveClicked() {
        Flow.get(view).goBack()
    }

}