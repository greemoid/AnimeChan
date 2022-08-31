package com.greemoid.animechan.core.data

interface CommonDataModelMapper<T> {
    fun map(id: Int, text: String, character: String, anime: String, cached: Boolean): T
}