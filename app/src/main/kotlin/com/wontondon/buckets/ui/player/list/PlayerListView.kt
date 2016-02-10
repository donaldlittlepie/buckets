package com.wontondon.buckets.ui.player.list

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import flow.Flow
import mortar.MortarScope
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class PlayerListView : LinearLayout {

    @Inject protected lateinit  var presenter: PlayerListScreenPresenter

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating PlayerListView")
        // Flow get dagger service inject
        Flow.getService<MortarScope>("mortar", context).getService<PlayerListScreen.Component>("dagger")
                .inject(this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter.takeView(this)
    }

    override fun onDetachedFromWindow() {
        presenter.dropView(this)
        super.onDetachedFromWindow()
    }
}