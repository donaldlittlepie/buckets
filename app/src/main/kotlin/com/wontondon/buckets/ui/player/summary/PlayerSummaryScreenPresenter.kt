package com.wontondon.buckets.ui.player.summary

import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.game.edit.EditGameScreen
import flow.Flow
import mortar.ViewPresenter
import timber.log.Timber
import javax.inject.Inject

@DaggerScope(PlayerSummaryScreen::class)
class PlayerSummaryScreenPresenter : ViewPresenter<PlayerSummaryView> {
    @Inject constructor() {
        Timber.d("Creating %s", PlayerSummaryScreenPresenter::class.java.simpleName)
    }

    fun addGameClicked() {
        Flow.get(view).set(EditGameScreen())
    }
}