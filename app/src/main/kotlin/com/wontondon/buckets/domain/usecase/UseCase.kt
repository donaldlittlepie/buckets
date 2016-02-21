package com.wontondon.buckets.domain.usecase

import rx.Observable

/**
 * Created by donnie on 2/20/16.
 */
interface UseCase<T> {
    fun execute(): Observable<T>
}