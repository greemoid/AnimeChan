package com.greemoid.animechan.core.domain

import com.greemoid.animechan.core.presentation.Failure

interface FailureHandler {
    fun handle(e: Exception): Failure
}