package com.greemoid.animechan.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.animechan.core.domain.CommonInteractor
import com.greemoid.animechan.core.presentation.CommonViewModel
import com.greemoid.animechan.core.presentation.Communication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseViewModel(
    private val interactor: CommonInteractor,
    private val communication: Communication,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main,
) : ViewModel(), CommonViewModel {


    override fun getQuote() {
        viewModelScope.launch(dispatcher) {
            communication.showState(State.Progress)
            interactor.getQuote().to().show(communication)
        }
    }

    override fun changeQuoteStatus() {
        viewModelScope.launch(dispatcher) {
            if (communication.isState(State.INITIAL)) {
                interactor.changeQuoteStatus().to().show(communication)
            }
        }
    }

    override fun chooseFavorites(favorites: Boolean) = interactor.getFavorites(favorites)

    override fun observe(owner: LifecycleOwner, observer: Observer<State>) =
        communication.observe(owner, observer)
}