package com.wontondon.buckets

import android.content.Context
import com.wontondon.buckets.ui.ContextServices
import com.wontondon.buckets.ui.player.list.PlayerListScreen
import flow.Services
import flow.ServicesFactory
import mortar.MortarScope
import timber.log.Timber

/**
 * Created by donnie on 2/10/16.
 */
class FlowServices(val context: Context) : ServicesFactory() {

    override fun bindServices(services: Services.Binder) {
        val key = services.getKey<PlayerListScreen>();

        val parentScope = MortarScope.getScope(context)
        val component = key.createComponent(parentScope.getService(ContextServices.DAGGER_SERVICE))

        val mortarScope = parentScope.buildChild()
            .withService(ContextServices.DAGGER_SERVICE, component)
            .build(key.javaClass.simpleName)

        services.bind(ContextServices.DAGGER_SERVICE,
                mortarScope.getService(ContextServices.DAGGER_SERVICE))
    }

    override fun tearDown(services: Services) {
        val key = services.getKey<Any>();
        val serviceName = key.javaClass.simpleName
        Timber.d("Tearing down flow service {}", serviceName)

        val parentScope = MortarScope.getScope(context)
        val screenScope = parentScope.findChild(key.javaClass.simpleName)
        if (screenScope != null) {
            Timber.d("Found screen scope {}. Destroying", screenScope)
            screenScope.destroy()
        }

        super.tearDown(services)
    }
}
