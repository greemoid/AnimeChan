package com.greemoid.animechan.core.data

import com.greemoid.animechan.data.CommonDataModel

interface ChangeCommonItem {
    suspend fun change(changeStatus: ChangeStatus): CommonDataModel

    class Empty : ChangeCommonItem {
        override suspend fun change(changeStatus: ChangeStatus): CommonDataModel {
            throw IllegalStateException("Empty Quote!")
        }
    }
}