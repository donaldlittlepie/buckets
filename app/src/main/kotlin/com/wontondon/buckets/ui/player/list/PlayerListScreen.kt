package com.wontondon.buckets.ui.player.list

import com.wontondon.buckets.R
import com.wontondon.buckets.domain.Player
import com.wontondon.buckets.domain.usecase.GetPlayerList
import com.wontondon.buckets.domain.usecase.UseCase
import com.wontondon.buckets.ui.ComponentFactory
import com.wontondon.buckets.ui.HasLayout
import com.wontondon.buckets.ui.ToolbarPresenter
import com.wontondon.buckets.ui.di.DaggerScope
import com.wontondon.buckets.ui.di.components.ApplicationComponent
import dagger.Provides
import dagger.Subcomponent
import org.parceler.Parcel
import timber.log.Timber
import dagger.Component as DaggerComponent
import dagger.Module as DaggerModule

/**
 * Screen for showing a list of players.
 *
 * @author Donnie McNeal (donnie.mcneal@gmail.com)
 */
@Parcel
class PlayerListScreen : HasLayout, ComponentFactory<ApplicationComponent> {
    init {
        Timber.d("%s created", PlayerListScreen::class.java.simpleName)
    }

    @DaggerModule
    class PlayerListScreenModule {

        @Provides
        @DaggerScope(PlayerListScreen::class)
        fun getPlayerListUseCase(usecase: GetPlayerList): UseCase<List<Player>> = usecase

        @Provides
        @DaggerScope(PlayerListScreen::class)
        fun toolbarPresenter(): ToolbarPresenter = ToolbarPresenter()
    }

    @Subcomponent(modules = arrayOf(PlayerListScreenModule::class))
    @DaggerScope(PlayerListScreen::class)
    interface PlayerListScreenComponent {
        fun inject(view: PlayerListView)
    }

    override fun createComponent(parent: ApplicationComponent): PlayerListScreenComponent = parent.plus(PlayerListScreenModule())

    override fun getLayout(): Int = R.layout.screen_player_list
}

