package com.greemoid.animechan.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.greemoid.animechan.presentation.State

interface Communication {
    fun showState(state: State)
    fun isState(type: Int): Boolean
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
}