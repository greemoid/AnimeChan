package com.greemoid.animechan.domain

import com.greemoid.animechan.core.data.Mapper
import com.greemoid.animechan.core.presentation.Failure
import com.greemoid.animechan.presentation.*

sealed class CommonItem : Mapper<CommonUiModel> {

    class Success(
         val quote: String,
         val character: String,
         val anime: String,
         val favorite: Boolean = true,
    ) : CommonItem() {
        override fun to(): CommonUiModel {
            return if (favorite) {
                FavoriteCommonUiModel(quote, character, anime)
            } else {
                BaseCommonUiModel(quote, character, anime)
            }
        }

    }

    class Failed(private val failure: Failure) : CommonItem() {
        override fun to(): CommonUiModel {
            return FailedCommonUiModel(failure.getMessage())
        }

    }

}