package com.wontondon.buckets.ui.game.view

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
class ViewGameView : LinearLayout {

    @Inject protected lateinit  var presenter: ViewGamePresenter


    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating %s", ViewGameView::class.java.simpleName)
        Flow.getService<ViewGameScreen.Component>(ContextServices.DAGGER_SERVICE, context)
                ?.inject(this)
    }

    @OnClick(R.id.btn_edit_game)
    fun editGameClicked() {
        this.presenter.editGameClicked()
    }

    @OnClick(R.id.btn_score_game)
    fun scoreGameClicked() {
        this.presenter.scoreGameClicked()
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