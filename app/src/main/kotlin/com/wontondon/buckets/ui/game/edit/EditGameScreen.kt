package com.wontondon.buckets.ui.game.edit

import com.wontondon.buckets.R
import com.wontondon.buckets.ui.ComponentFactory
import com.wontondon.buckets.ui.HasLayout
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.di.components.ApplicationComponent
import org.parceler.Parcel
import dagger.Component as DaggerComponent

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
@Parcel
class EditGameScreen : HasLayout, ComponentFactory<ApplicationComponent> {

    @DaggerComponent(dependencies = arrayOf(ApplicationComponent::class))
    @DaggerScope(EditGameScreen::class)
    interface Component {
        fun inject(view: EditGameView)
    }

    override fun createComponent(parent: ApplicationComponent): Any {
        return DaggerEditGameScreen_Component.builder()
                .applicationComponent(parent)
                .build()
    }

    override fun getLayout(): Int = R.layout.screen_edit_game
}

