package com.example.seekhoassignment.domain.util

import com.example.seekhoassignment.data.util.ResponseState


fun <T> ResponseState<T>.toApiResult(): ApiResult<T> {
    return when (this) {
        is ResponseState.Success -> {
            ApiResult.Success(this.data)
        }

        is ResponseState.ErrorMessage -> {
            ApiResult.ErrorMessage(this.message)
        }

        is ResponseState.NoInternet -> {
            ApiResult.NoInternet
        }
    }
}