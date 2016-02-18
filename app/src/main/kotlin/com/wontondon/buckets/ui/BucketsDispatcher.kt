package com.wontondon.buckets.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wontondon.buckets.R
import flow.Flow
import timber.log.Timber

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class BucketsDispatcher(private val activity: Activity) : Flow.Dispatcher {

    override fun dispatch(traversal: Flow.Traversal, callback: Flow.TraversalCallback) {
        Timber.d("dispatching %s", traversal)

        // FIXME explicit check? Would this ever be incorrect?
        val destination = traversal.destination.top<Any>() as HasLayout

        val frame = activity.findViewById(R.id.app_container) as ViewGroup

        traversal.origin?.let { origin ->
            if (frame.childCount > 0) {
                traversal.getState(origin.top()).save(frame.getChildAt(0))
                frame.removeAllViews()
            }
        }

        val layout = destination.getLayout()

        val incomingView = LayoutInflater.from(traversal.createContext(destination, activity))
            .inflate(layout, frame, false)

        frame.addView(incomingView)
        traversal.getState(traversal.destination.top()).restore(incomingView)

        callback.onTraversalCompleted()
    }
}
