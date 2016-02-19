package com.wontondon.buckets.ui.game.list

import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ComponentFactory
import com.wontondon.buckets.ui.HasLayout
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.di.components.ApplicationComponent
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import org.parceler.Parcel
import dagger.Component as DaggerComponent

/**
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Parcel
class GameListScreen : HasLayout, ComponentFactory<ApplicationComponent> {

    @Module
    class GameListScreenModule {

        @Provides
        @DaggerScope(GameListScreen::class)
        fun toolbarPresenter(): ToolbarPresenter = ToolbarPresenter()
    }

    @Subcomponent(modules = arrayOf(GameListScreenModule::class))
    @DaggerScope(GameListScreen::class)
    interface GameListScreenComponent {
        fun inject(view: GameListView)
    }

    override fun createComponent(parent: ApplicationComponent): GameListScreenComponent =
        parent.plus(GameListScreenModule())

    override fun getLayout(): Int = R.layout.screen_game_list
}

