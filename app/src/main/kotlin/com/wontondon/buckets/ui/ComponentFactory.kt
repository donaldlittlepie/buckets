package com.wontondon.buckets.ui

/**
 * Created by donnie on 2/10/16.
 */
interface ComponentFactory<PARENT> {

    fun createComponent(parent: PARENT): Any
}