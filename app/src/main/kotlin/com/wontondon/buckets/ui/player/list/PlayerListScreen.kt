package com.wontondon.buckets.ui.player.list

import com.wontondon.buckets.R
import com.wontondon.buckets.ui.HasLayout
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.di.components.ApplicationComponent
import org.parceler.Parcel
import dagger.Component as DaggerComponent

/**
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Parcel
class PlayerListScreen : HasLayout {

    @DaggerComponent(dependencies = arrayOf(ApplicationComponent::class))
    @DaggerScope(PlayerListScreen::class)
    interface Component {
        fun inject(view: PlayerListView)
    }

    fun createComponent(parent: ApplicationComponent): PlayerListScreen.Component {
        return DaggerPlayerListScreen_Component.builder()
            .applicationComponent(parent)
            .build()
    }

    override fun getLayout(): Int = R.layout.screen_player_list
}

