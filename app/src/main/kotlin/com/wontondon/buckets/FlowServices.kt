package com.wontondon.buckets

import android.content.Context
import com.wontondon.buckets.ui.player.list.PlayerListScreen
import flow.Services
import flow.ServicesFactory
import mortar.MortarScope

/**
 * Created by donnie on 2/10/16.
 */
class FlowServices(val context: Context) : ServicesFactory() {

    override fun bindServices(services: Services.Binder) {
        val key = services.getKey<PlayerListScreen>();

        val parentScope = MortarScope.getScope(context)
        val component = key.createComponent(parentScope.getService("dagger"))

        val mortarScope = parentScope.buildChild()
            .withService("dagger", component)
            .build("mortar")

        services.bind("mortar", mortarScope)
    }

}
