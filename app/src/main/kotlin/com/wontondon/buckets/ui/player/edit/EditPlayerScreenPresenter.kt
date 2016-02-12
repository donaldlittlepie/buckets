package com.wontondon.buckets.ui.player.edit

import com.wontondon.buckets.ui.di.DaggerScope
import mortar.ViewPresenter
import timber.log.Timber
import javax.inject.Inject

@DaggerScope(EditPlayerScreen::class)
class EditPlayerScreenPresenter : ViewPresenter<EditPlayerView> {
    @Inject constructor() {
        Timber.d("Creating %s", EditPlayerScreenPresenter::class.java.simpleName)
    }
}