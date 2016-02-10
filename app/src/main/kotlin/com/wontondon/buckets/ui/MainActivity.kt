package com.wontondon.buckets.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wontondon.buckets.R
import com.wontondon.buckets.ui.player.list.PlayerListScreen
import flow.Flow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(newBase: Context?) {
        val context = Flow.configure(newBase, this)
                .dispatcher(BucketsDispatcher(this))
                .defaultKey(PlayerListScreen())
                .keyParceler(BucketsKeyParceler())
                .install()

        super.attachBaseContext(context)
    }

    override fun onBackPressed() {
        if (!Flow.get(this).goBack())
            super.onBackPressed()
    }
}
