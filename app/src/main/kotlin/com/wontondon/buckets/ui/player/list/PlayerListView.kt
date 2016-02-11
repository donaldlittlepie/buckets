package com.wontondon.buckets.ui.player.list

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import butterknife.ButterKnife
import butterknife.OnClick
import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ContextServices
import flow.Flow
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class PlayerListView : LinearLayout {

    @Inject protected lateinit  var presenter: PlayerListScreenPresenter


    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating PlayerListView")
        Flow.getService<PlayerListScreen.Component>(ContextServices.DAGGER_SERVICE, context)
                .inject(this)
    }

    @OnClick(R.id.btn_add_player)
    fun addPlayerClicked() {
        this.presenter.addPlayerClicked()
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter.takeView(this)
    }

    override fun onDetachedFromWindow() {
        presenter.dropView(this)
        super.onDetachedFromWindow()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        ButterKnife.bind(this)
    }
}