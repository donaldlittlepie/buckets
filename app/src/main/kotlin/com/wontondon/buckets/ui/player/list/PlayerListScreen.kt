package com.wontondon.buckets.ui.player.list

import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ComponentFactory
import com.wontondon.buckets.ui.HasLayout
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.di.components.ApplicationComponent
import dagger.Provides
import dagger.Subcomponent
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

    @Subcomponent(modules = arrayOf(Module::class))
    @DaggerScope(PlayerListScreen::class)
    interface PlayerListScreenComponent {
        fun inject(view: PlayerListView)
    }

    override fun createComponent(parent: ApplicationComponent): PlayerListScreenComponent = parent.plus(Module())

    override fun getLayout(): Int = R.layout.screen_player_list
}

