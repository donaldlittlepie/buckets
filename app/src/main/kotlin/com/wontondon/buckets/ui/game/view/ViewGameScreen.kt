package com.wontondon.buckets.ui.game.view

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
class ViewGameScreen : HasLayout, ComponentFactory<ApplicationComponent> {

    @Module
    class ViewGameScreenModule {
        @Provides
        @DaggerScope(ViewGameScreen::class)
        fun toolbarPresenter(): ToolbarPresenter = ToolbarPresenter()
    }

    @Subcomponent(modules = arrayOf(ViewGameScreenModule::class))
    @DaggerScope(ViewGameScreen::class)
    interface ViewGameScreenComponent {
        fun inject(view: ViewGameView)
    }

    override fun createComponent(parent: ApplicationComponent): ViewGameScreenComponent =
        parent.plus(ViewGameScreenModule())

    override fun getLayout(): Int = R.layout.screen_view_game
}

