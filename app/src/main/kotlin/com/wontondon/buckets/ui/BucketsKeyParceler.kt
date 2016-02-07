package com.wontondon.buckets.ui

import android.os.Parcelable
import flow.KeyParceler
import org.parceler.Parcels

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
class BucketsKeyParceler : KeyParceler {
    override fun toParcelable(key: Any?): Parcelable? {
        return Parcels.wrap(key)
    }

    override fun toKey(parcelable: Parcelable?): Any? {
        return Parcels.unwrap(parcelable)
    }
}