package com.wontondon.buckets.ui.game.edit

import com.wontondon.buckets.ui.di.DaggerScope
import flow.Flow
import mortar.ViewPresenter
import timber.log.Timber
import javax.inject.Inject

@DaggerScope(EditGameScreen::class)
class EditGameScreenPresenter : ViewPresenter<EditGameView> {
    @Inject constructor() {
        Timber.d("Creating %s", EditGameScreenPresenter::class.java.simpleName)
    }

    fun saveClicked() {
        Flow.get(view).goBack()
    }

}