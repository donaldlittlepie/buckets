package com.wontondon.buckets.ui.game.edit

import com.wontondon.buckets.R
import com.wontondon.buckets.domain.Game
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
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
@Parcel
class EditGameScreen(
        @JvmField var gameId: Int? = null
) : HasLayout, ComponentFactory<ApplicationComponent> {

    @Module
    class EditGameScreenModule(val gameId: Int? = null) {

        @Provides
        @DaggerScope(EditGameScreen::class)
        fun toolbarPresenter(): ToolbarPresenter = ToolbarPresenter()

        @Provides
        @DaggerScope(EditGameScreen::class)
        fun game(): Game? = gameId?.let { Game() }
    }

    @Subcomponent(modules = arrayOf(EditGameScreenModule::class))
    @DaggerScope(EditGameScreen::class)
    interface EditGameScreenComponent {
        fun inject(view: EditGameView)
    }

    override fun createComponent(parent: ApplicationComponent): EditGameScreenComponent =
            parent.plus(EditGameScreenModule(gameId = gameId))

    override fun getLayout(): Int = R.layout.screen_edit_game
}

