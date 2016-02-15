package com.wontondon.buckets.ui.game.list

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
class GameListView : LinearLayout {

    @Inject protected lateinit  var presenter: GameListScreenPresenter


    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating %s", GameListView::class.java.simpleName)
        Flow.getService<GameListScreen.Component>(ContextServices.DAGGER_SERVICE, context)
                ?.inject(this)
    }

    @OnClick(R.id.btn_add_game)
    fun addGameClicked() {
        this.presenter.addGameClicked()
    }

    @OnClick(R.id.btn_view_game)
    fun viewGameClicked() {
        this.presenter.viewGameClicked()
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