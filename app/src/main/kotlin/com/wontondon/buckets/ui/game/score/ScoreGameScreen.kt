package com.wontondon.buckets.ui.game.score

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
class ScoreGameScreen : HasLayout, ComponentFactory<ApplicationComponent> {

    @DaggerComponent(dependencies = arrayOf(ApplicationComponent::class))
    @DaggerScope(ScoreGameScreen::class)
    interface Component {
        fun inject(view: ScoreGameView)
    }

    override fun createComponent(parent: ApplicationComponent): ScoreGameScreen.Component {
        return DaggerScoreGameScreen_Component.builder()
            .applicationComponent(parent)
            .build()
    }

    override fun getLayout(): Int = R.layout.screen_score_game
}

