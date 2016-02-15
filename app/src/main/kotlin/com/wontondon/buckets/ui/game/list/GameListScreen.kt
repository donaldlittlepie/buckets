package com.wontondon.buckets.ui.game.list

import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ComponentFactory
import com.wontondon.buckets.ui.HasLayout
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.di.components.ApplicationComponent
import org.parceler.Parcel
import dagger.Component as DaggerComponent

/**
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Parcel
class GameListScreen : HasLayout, ComponentFactory<ApplicationComponent> {

    @DaggerComponent(dependencies = arrayOf(ApplicationComponent::class))
    @DaggerScope(GameListScreen::class)
    interface Component {
        fun inject(view: GameListView)
    }

    override fun createComponent(parent: ApplicationComponent): GameListScreen.Component {
        return DaggerGameListScreen_Component.builder()
            .applicationComponent(parent)
            .build()
    }

    override fun getLayout(): Int = R.layout.screen_game_list
}

