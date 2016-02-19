package com.wontondon.buckets.ui.player.edit

import android.os.Bundle
import com.wontondon.buckets.domain.Player
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import flow.Flow
import mortar.ViewPresenter
import javax.inject.Inject

@DaggerScope(EditPlayerScreen::class)
class EditPlayerScreenPresenter @Inject constructor(
        val player: Player?,
        val toolbarPresenter: ToolbarPresenter
) : ViewPresenter<EditPlayerView>() {


    override fun onLoad(savedInstanceState: Bundle?) {
        if (player == null) {
            toolbarPresenter.setTitle("Add Player")
        }
        else {
            toolbarPresenter.setTitle("Edit Player")
        }
    }

    fun onSaveClicked() {
        Flow.get(view).goBack()
    }
}