package com.greemoid.animechan.core.data

import com.greemoid.animechan.data.CommonDataModel

interface ChangeStatus {
    suspend fun addOrRemove(model: CommonDataModel): CommonDataModel
}