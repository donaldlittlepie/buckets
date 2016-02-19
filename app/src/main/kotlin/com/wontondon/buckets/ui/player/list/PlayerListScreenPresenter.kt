package com.wontondon.buckets.ui.player.list

import android.os.Bundle
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.player.edit.EditPlayerScreen
import com.wontondon.buckets.ui.player.view.ViewPlayerScreen
import flow.Flow
import mortar.ViewPresenter
import timber.log.Timber
import javax.inject.Inject

@DaggerScope(PlayerListScreen::class)
class PlayerListScreenPresenter : ViewPresenter<PlayerListView> {

    lateinit var toolbar: ToolbarPresenter
    @Inject constructor(toolbar: ToolbarPresenter) {
        Timber.d("Creating PlayerListScreenPresenter")
        this.toolbar = toolbar
    }

    override fun onLoad(savedInstanceState: Bundle?) {
        super.onLoad(savedInstanceState)
        this.toolbar.setTitle("Buckets")
    }

    fun addPlayerClicked() {
        Flow.get(view).set(EditPlayerScreen())
    }

    fun viewPlayerClicked() {
        Flow.get(view).set(ViewPlayerScreen())
    }
}