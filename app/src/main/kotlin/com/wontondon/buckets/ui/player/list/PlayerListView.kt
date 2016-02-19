package com.wontondon.buckets.ui.player.list

import android.content.Context
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.widget.LinearLayout
import butterknife.Bind
import butterknife.ButterKnife
import butterknife.OnClick
import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ContextServices
import com.wontondon.buckets.ui.ToolbarPresenter
import flow.Flow
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class PlayerListView : LinearLayout {

    @Inject
    protected lateinit  var presenter: PlayerListScreenPresenter

    @Inject
    protected lateinit  var toolbarPresenter: ToolbarPresenter

    @Bind(R.id.app_toolbar)
    protected lateinit var toolbar: Toolbar

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating PlayerListView")
        Flow.getService<PlayerListScreen.Component>(ContextServices.DAGGER_SERVICE, context)
                ?.inject(this)
    }

    @OnClick(R.id.btn_add_player)
    fun addPlayerClicked() {
        this.presenter.addPlayerClicked()
    }

    @OnClick(R.id.btn_view_player)
    fun viewPlayerClicked() {
        this.presenter.viewPlayerClicked()
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        toolbarPresenter.takeView(toolbar)
        presenter.takeView(this)
    }

    override fun onDetachedFromWindow() {
        presenter.dropView(this)
        toolbarPresenter.dropView(toolbar)
        super.onDetachedFromWindow()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        ButterKnife.bind(this)
    }
}