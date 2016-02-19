package com.wontondon.buckets.ui.player.edit

import com.wontondon.buckets.R
import com.wontondon.buckets.domain.Player
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
class EditPlayerScreen(
        @JvmField var playerId: Int? = null
) : HasLayout, ComponentFactory<ApplicationComponent> {

    @DaggerModule
    class EditPlayerScreenModule(val playerId: Int?) {

        @Provides
        @DaggerScope(EditPlayerScreen::class)
        fun toolbarPresenter(): ToolbarPresenter = ToolbarPresenter()

        @Provides
        @DaggerScope(EditPlayerScreen::class)
        fun getPlayer(): Player? =  playerId?.let { Player() }
    }


    @Subcomponent(modules = arrayOf(EditPlayerScreenModule::class))
    @DaggerScope(EditPlayerScreen::class)
    interface EditPlayerScreenComponent {
        fun inject(view: EditPlayerView)
    }

    override fun createComponent(parent: ApplicationComponent): EditPlayerScreenComponent =
            parent.plus(EditPlayerScreenModule(playerId))

    override fun getLayout(): Int = R.layout.screen_edit_player
}

