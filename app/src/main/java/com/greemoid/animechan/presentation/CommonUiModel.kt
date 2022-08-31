package com.greemoid.animechan.presentation

import androidx.annotation.DrawableRes
import com.greemoid.animechan.R
import com.greemoid.animechan.core.presentation.Communication


class BaseCommonUiModel(text: String, character: String, anime: String) :
    CommonUiModel(text, character, anime) {
    override fun getIconResId(): Int = R.drawable.ic_favorite_border
}

class FavoriteCommonUiModel(text: String, character: String, anime: String) :
    CommonUiModel(text, character, anime) {
    override fun getIconResId(): Int = R.drawable.ic_favorite_filled
}

class FailedCommonUiModel(private val text: String) :
    CommonUiModel(text, "", "") {
    override fun text(): String = text
    override fun getIconResId(): Int = 0
    override fun show(communication: Communication) =
        communication.showState(State.Failed(text(), getIconResId()))
}

abstract class CommonUiModel(
    private val text: String,
    private val character: String,
    private val anime: String,
) {
    protected open fun text() = "$text\n$character\n$anime"

    @DrawableRes
    protected abstract fun getIconResId(): Int

    open fun show(communication: Communication) =
        communication.showState(State.Initial(text(), getIconResId()))
}