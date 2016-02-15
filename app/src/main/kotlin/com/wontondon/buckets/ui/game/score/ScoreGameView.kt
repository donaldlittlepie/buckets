package com.wontondon.buckets.ui.game.score

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import butterknife.ButterKnife
import com.wontondon.buckets.ui.ContextServices
import flow.Flow
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class ScoreGameView : LinearLayout {

    @Inject protected lateinit  var presenter: ScoreGamePresenter


    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating %s", ScoreGameView::class.java.simpleName)
        Flow.getService<ScoreGameScreen.Component>(ContextServices.DAGGER_SERVICE, context)
                ?.inject(this)
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