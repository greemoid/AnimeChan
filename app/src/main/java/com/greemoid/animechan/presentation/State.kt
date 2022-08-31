package com.greemoid.animechan.presentation

import androidx.annotation.DrawableRes
import com.greemoid.animechan.core.presentation.ShowImageButton
import com.greemoid.animechan.core.presentation.ShowText
import com.greemoid.animechan.core.presentation.ShowView

sealed class State {

    protected abstract val type: Int

    companion object {
        const val INITIAL = 0
        const val PROGRESS = 1
        const val FAILED = 2
    }

    fun isType(type: Int): Boolean = this.type == type

    fun show(
        progressBar: ShowView,
        button: ShowView,
        textView: ShowText,
        imageButton: ShowImageButton,
    ) {
        show(progressBar, button)
        show(textView, imageButton)
    }

    protected open fun show(progressBar: ShowView, button: ShowView) {}
    protected open fun show(textView: ShowText, imageButton: ShowImageButton) {}

    object Progress : State() {
        override val type: Int = PROGRESS

        override fun show(progressBar: ShowView, button: ShowView) {
            progressBar.show(true)
            button.show(false)
        }
    }

    abstract class Info(private val text: String, @DrawableRes private val id: Int) : State() {
        override fun show(progressBar: ShowView, button: ShowView) {
            progressBar.show(false)
            button.show(true)
        }

        override fun show(textView: ShowText, imageButton: ShowImageButton) {
            textView.show(text)
            imageButton.show(id)
        }
    }

    class Initial(text: String, @DrawableRes id: Int) : Info(text, id) {
        override val type: Int = INITIAL
    }

    class Failed(text: String, @DrawableRes id: Int) : Info(text, id) {
        override val type: Int = FAILED
    }
}