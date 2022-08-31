package com.greemoid.animechan.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.greemoid.animechan.core.presentation.ShowImageButton
import com.greemoid.animechan.core.presentation.ShowText
import com.greemoid.animechan.core.presentation.ShowView

class CorrectTextView : AppCompatTextView, ShowText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun show(arg: String) {
        text = arg
    }
}

class CorrectImageButton : AppCompatImageButton, ShowImageButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun show(arg: Int) {
        setImageResource(arg)
    }
}

class CorrectProgressBar : ProgressBar, ShowView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun show(arg: Boolean) {
        visibility = if (arg) View.VISIBLE else View.INVISIBLE
    }
}

class CorrectButton : AppCompatButton, ShowView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun show(arg: Boolean) {
        isEnabled = arg
    }
}