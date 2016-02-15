package com.wontondon.buckets.ui.game.view

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
class ViewGameScreen : HasLayout, ComponentFactory<ApplicationComponent> {

    @DaggerComponent(dependencies = arrayOf(ApplicationComponent::class))
    @DaggerScope(ViewGameScreen::class)
    interface Component {
        fun inject(view: ViewGameView)
    }

    override fun createComponent(parent: ApplicationComponent): ViewGameScreen.Component {
        return DaggerViewGameScreen_Component.builder()
            .applicationComponent(parent)
            .build()
    }

    override fun getLayout(): Int = R.layout.screen_view_game
}

