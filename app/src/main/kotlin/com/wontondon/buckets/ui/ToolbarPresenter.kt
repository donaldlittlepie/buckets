package com.wontondon.buckets.ui

import android.support.v7.widget.Toolbar
import mortar.ViewPresenter

/**
 * Created by donnie on 2/18/16.
 */
class ToolbarPresenter : ViewPresenter<Toolbar>() {

    fun setTitle(title: String) {
        view.title = title
    }
}
