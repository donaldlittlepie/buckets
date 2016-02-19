package com.wontondon.buckets.ui.player.list

import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ComponentFactory
import com.wontondon.buckets.ui.HasLayout
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.di.components.ApplicationComponent
import dagger.Provides
import org.parceler.Parcel
import dagger.Component as DaggerComponent
import dagger.Module as DaggerModule

/**
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Parcel
class PlayerListScreen : HasLayout, ComponentFactory<ApplicationComponent> {

    @DaggerModule
    class Module {

        @Provides
        @DaggerScope(PlayerListScreen::class)
        fun toolbarPresenter(): ToolbarPresenter = ToolbarPresenter()
    }

    @DaggerComponent(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(Module::class))
    @DaggerScope(PlayerListScreen::class)
    interface Component {
        fun inject(view: PlayerListView)
    }

    override fun createComponent(parent: ApplicationComponent): PlayerListScreen.Component {
        return DaggerPlayerListScreen_Component.builder()
            .applicationComponent(parent)
            .build()
    }

    override fun getLayout(): Int = R.layout.screen_player_list
}

