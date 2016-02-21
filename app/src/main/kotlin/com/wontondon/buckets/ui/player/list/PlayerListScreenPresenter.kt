package com.wontondon.buckets.ui.player.list

import android.os.Bundle
import com.wontondon.buckets.domain.usecase.GetPlayerList
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.player.edit.EditPlayerScreen
import com.wontondon.buckets.ui.player.view.ViewPlayerScreen
import flow.Flow
import mortar.ViewPresenter
import rx.Subscription
import javax.inject.Inject

@DaggerScope(PlayerListScreen::class)
class PlayerListScreenPresenter @Inject constructor(
        val toolbar: ToolbarPresenter,
        val useCase: GetPlayerList
) : ViewPresenter<PlayerListView>() {

    private var useCaseSubscription: Subscription? = null

    override fun onLoad(savedInstanceState: Bundle?) {
        super.onLoad(savedInstanceState)
        this.toolbar.setTitle("Buckets")

        useCaseSubscription = useCase.execute()
                .subscribe({ players ->
                    view.showPlayers(players)
                })
    }

    override fun onExitScope() {
        unsubscribeObservables()
    }

    fun addPlayerClicked() {
        Flow.get(view).set(EditPlayerScreen())
    }

    fun viewPlayerClicked() {
        Flow.get(view).set(ViewPlayerScreen())
    }

    private fun unsubscribeObservables() {
        useCaseSubscription?.unsubscribe()
    }
}