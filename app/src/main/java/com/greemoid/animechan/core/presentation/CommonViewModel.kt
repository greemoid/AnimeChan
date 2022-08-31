package com.greemoid.animechan.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.greemoid.animechan.presentation.State

interface CommonViewModel {
    fun getQuote()
    fun changeQuoteStatus()
    fun chooseFavorites(favorites: Boolean)
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
}