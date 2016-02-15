package com.wontondon.buckets.ui.player.list

import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.player.edit.EditPlayerScreen
import com.wontondon.buckets.ui.player.view.ViewPlayerScreen
import flow.Flow
import mortar.ViewPresenter
import timber.log.Timber
import javax.inject.Inject

@DaggerScope(PlayerListScreen::class)
class PlayerListScreenPresenter : ViewPresenter<PlayerListView> {
    @Inject constructor() {
        Timber.d("Creating PlayerListScreenPresenter")
    }

    fun addPlayerClicked() {
        Flow.get(view).set(EditPlayerScreen())
    }

    fun viewPlayerClicked() {
        Flow.get(view).set(ViewPlayerScreen())
    }
}