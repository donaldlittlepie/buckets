package com.wontondon.buckets.ui

import flow.Services
import flow.ServicesFactory
import mortar.MortarScope
import timber.log.Timber

/**
 * Created by donnie on 2/10/16.
 */
class FlowServices(private var parentScope: MortarScope) : ServicesFactory() {

    override fun bindServices(services: Services.Binder) {
        val key = services.getKey<Any>() as ComponentFactory<Any>;
        Timber.d("Binding service %s", key)

        var childScope = parentScope.findChild(key.javaClass.simpleName)
        if (childScope == null) {
            Timber.d("Creating child scope %s", key.javaClass.simpleName)
            val component = key.createComponent(
                    parentScope.getService(ContextServices.DAGGER_SERVICE))

            childScope = parentScope.buildChild()
                    .withService(ContextServices.DAGGER_SERVICE, component)
                    .build(key.javaClass.simpleName)
        }

        services.bind(ContextServices.DAGGER_SERVICE,
                childScope.getService(ContextServices.DAGGER_SERVICE))
    }

    override fun tearDownServices(services: Services) {
        val key = services.getKey<Any>();
        val serviceName = key.javaClass.simpleName
        Timber.d("Tearing down flow service %s", serviceName)

        val screenScope = parentScope.findChild(key.javaClass.simpleName)
        if (screenScope != null) {
            Timber.d("Found screen scope %s. Destroying", screenScope)
            screenScope.destroy()
        }

        super.tearDownServices(services)
    }
}
