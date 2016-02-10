package com.wontondon.buckets.ui

/**
 * @author Donnie McNeal, Jr. (donnie.mcneal@gmail.com)
 */
interface HasLayout {

    /**
     * Get the layout identifier for the class
     *
     * @return layout resource id
     */
    fun getLayout() : Int
}