package com.wontondon.buckets.ui

import android.app.Activity
import android.content.Context
import android.transition.AutoTransition
import android.transition.Scene
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wontondon.buckets.R
import flow.Flow
import flow.KeyChanger
import flow.State

/**
 * Flow dispatcher which animates scene transitions.
 */
class SceneDispatcher(private val activity: Activity) : KeyChanger() {

    override fun changeKey(outgoingState: State?, incomingState: State, direction: Flow.Direction,
            incomingContexts: MutableMap<Any, Context>, callback: Flow.TraversalCallback) {

        val destination = incomingState.getKey<HasLayout>()
        val context = incomingContexts.get(destination)
        val layout = destination.getLayout()
        // TODO does this really need to be the activity
        val frame = activity.findViewById(R.id.app_container) as ViewGroup
        val incomingView = LayoutInflater.from(context).inflate(layout, frame, false)

        outgoingState?.let { state ->
            state.save(frame.getChildAt(0))
        }

        val transition = if (outgoingState != null) {
            AutoTransition()
        } else {
            null
        }

        val scene = Scene(frame, incomingView)
        TransitionManager.go(scene, transition)
        incomingState.restore(incomingView)

        callback.onTraversalCompleted()
    }
}