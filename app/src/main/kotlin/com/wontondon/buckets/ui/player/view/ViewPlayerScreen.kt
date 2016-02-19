package com.wontondon.buckets.ui.player.view

import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ComponentFactory
import com.wontondon.buckets.ui.HasLayout
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.di.components.ApplicationComponent
import dagger.Module
import dagger.Subcomponent
import org.parceler.Parcel
import dagger.Component as DaggerComponent

/**
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Parcel
class ViewPlayerScreen : HasLayout, ComponentFactory<ApplicationComponent> {

    @Module
    class ViewPlayerScreenModule

    @Subcomponent(modules = arrayOf(ViewPlayerScreenModule::class))
    @DaggerScope(ViewPlayerScreen::class)
    interface ViewPlayerScreenComponent {
        fun inject(view: ViewPlayerView)
    }

    override fun createComponent(parent: ApplicationComponent): ViewPlayerScreenComponent =
            parent.plus(ViewPlayerScreenModule())

    override fun getLayout(): Int = R.layout.screen_view_player
}

