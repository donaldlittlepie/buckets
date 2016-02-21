package com.wontondon.buckets.domain.usecase

import com.wontondon.buckets.domain.Player
import rx.Observable
import javax.inject.Inject

/**
 * Retrieve a list of [Player]s
 *
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class GetPlayerList @Inject constructor() : UseCase<List<Player>> {

    override fun execute(): Observable<List<Player>> {
        return Observable.just(listOf(Player(), Player()))
    }
}
