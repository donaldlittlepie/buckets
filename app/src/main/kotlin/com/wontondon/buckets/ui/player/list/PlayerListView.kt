package com.wontondon.buckets.ui.player.list

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.Bind
import butterknife.ButterKnife
import butterknife.OnClick
import com.wontondon.buckets.R
import com.wontondon.buckets.domain.Player
import com.wontondon.buckets.ui.ContextServices
import com.wontondon.buckets.ui.ToolbarPresenter
import flow.Flow
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class PlayerListView : LinearLayout {

    @Inject
    protected lateinit  var presenter: PlayerListScreenPresenter

    @Inject
    protected lateinit  var toolbarPresenter: ToolbarPresenter

    @Bind(R.id.app_toolbar)
    protected lateinit var toolbar: Toolbar

    @Bind(R.id.player_list)
    lateinit var playerList: RecyclerView

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        Timber.d("Creating PlayerListView")
        Flow.getService<PlayerListScreen.PlayerListScreenComponent>(ContextServices.DAGGER_SERVICE, context)
                ?.inject(this)
    }

    @OnClick(R.id.btn_add_player)
    fun addPlayerClicked() {
        this.presenter.addPlayerClicked()
    }

    fun viewPlayerClicked() {
        this.presenter.viewPlayerClicked()
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        toolbarPresenter.takeView(toolbar)
        presenter.takeView(this)

        setupPlayerList()
    }

    override fun onDetachedFromWindow() {
        presenter.dropView(this)
        toolbarPresenter.dropView(toolbar)
        super.onDetachedFromWindow()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        ButterKnife.bind(this)
    }

    private fun setupPlayerList() {
        this.playerList.setHasFixedSize(true)
        this.playerList.layoutManager = LinearLayoutManager(context)
    }

    fun showPlayers(players: List<Player>){
        val adapter = PlayerListAdapter(players, {
            viewPlayerClicked()
        })
        playerList.adapter = adapter
    }
}

class PlayerListAdapter(
        val player: List<Player>,
        val onClickListener: () -> Unit
) : RecyclerView.Adapter<PlayerListViewHolder>() {

    override fun onBindViewHolder(viewHolder: PlayerListViewHolder, position: Int) {
        viewHolder.view.text = player[position].toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerListViewHolder {
        // TODO inflate and bind complex layout
        val view = TextView(parent.context)
        view.setOnClickListener{ onClickListener() }
        return PlayerListViewHolder(view)
    }

    override fun getItemCount(): Int = player.size

}

class PlayerListViewHolder(val view: TextView) : RecyclerView.ViewHolder(view)
