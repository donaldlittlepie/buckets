package com.wontondon.buckets.ui.player.edit

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.wontondon.buckets.ui.ContextServices
import flow.Flow
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class EditPlayerView : LinearLayout {

    @Inject protected lateinit  var presenter: EditPlayerScreenPresenter

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating %s", EditPlayerView::class.java.simpleName)
        Flow.getService<EditPlayerScreen.Component>(ContextServices.DAGGER_SERVICE, context)
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
}