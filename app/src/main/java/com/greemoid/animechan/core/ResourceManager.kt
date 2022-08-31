package com.greemoid.animechan.core

import androidx.annotation.StringRes

interface ResourceManager {
    fun getString(@StringRes stringRes: Int): String
}