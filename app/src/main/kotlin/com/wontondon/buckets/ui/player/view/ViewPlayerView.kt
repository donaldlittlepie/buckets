package com.wontondon.buckets.ui.player.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import butterknife.ButterKnife
import butterknife.OnClick
import com.wontondon.buckets.AnnotationHack
import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ContextServices
import flow.Flow
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class ViewPlayerView : LinearLayout {

    @Inject protected lateinit  var presenter: ViewPlayerScreenPresenter


    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating %s", ViewPlayerView::class.java.simpleName)
        Flow.getService<ViewPlayerScreen.Component>(ContextServices.DAGGER_SERVICE, context)
                ?.inject(this)
    }

    @AnnotationHack
    @OnClick(R.id.btn_add_game)
    fun addGameClicked() {
        this.presenter.addGameClicked()
    }

    @AnnotationHack
    @OnClick(R.id.btn_view_game_list)
    fun vewGameListClicked() {
        this.presenter.viewGameListClicked()
    }

    @OnClick(R.id.btn_edit_player)
    fun editPlayerClicked() {
        this.presenter.onEditPlayerClicked()
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