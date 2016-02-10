package com.wontondon.buckets.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wontondon.buckets.FlowServices
import com.wontondon.buckets.R
import com.wontondon.buckets.ui.player.list.PlayerListScreen
import flow.Flow
import mortar.MortarScope
import mortar.bundler.BundleServiceRunner

class MainActivity : AppCompatActivity() {
    private val ACTIVITY_SCOPE_NAME = "Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (!Flow.get(this).goBack())
            super.onBackPressed()
    }

    override fun attachBaseContext(newBase: Context?) {
        val context = Flow.configure(newBase, this)
                .addServicesFactory(FlowServices(this))
                .dispatcher(BucketsDispatcher(this))
                .defaultKey(PlayerListScreen())
                .keyParceler(BucketsKeyParceler())
                .install()

        super.attachBaseContext(context)
    }


    override fun getSystemService(name: String?): Any? {
        var activityScope = getMortarScope()

        return if (activityScope.hasService(name))
            return activityScope.getService(name)
        else
            super.getSystemService(name)
    }

    private fun getMortarScope(): MortarScope {
        var scope = MortarScope.findChild(applicationContext, ACTIVITY_SCOPE_NAME)
        if (scope == null) {
            scope = MortarScope.buildChild(applicationContext)
                    .withService(BundleServiceRunner.SERVICE_NAME, BundleServiceRunner())
                    // .withService("dagger", createComponent()) TODO Add dagger service if needed
                    .build(ACTIVITY_SCOPE_NAME)
        }

        return scope
    }


}
