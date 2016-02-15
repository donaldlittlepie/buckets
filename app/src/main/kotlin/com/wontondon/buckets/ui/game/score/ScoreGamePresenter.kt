package com.wontondon.buckets.ui.game.score

import com.wontondon.buckets.ui.di.DaggerScope
import mortar.ViewPresenter
import timber.log.Timber
import javax.inject.Inject

@DaggerScope(ScoreGameScreen::class)
class ScoreGamePresenter : ViewPresenter<ScoreGameView> {
    @Inject constructor() {
        Timber.d("Creating %s", ScoreGamePresenter::class.java.simpleName)
    }
}