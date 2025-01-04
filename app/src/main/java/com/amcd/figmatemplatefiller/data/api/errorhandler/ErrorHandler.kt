package com.amcd.figmatemplatefiller.data.api.errorhandler

import retrofit2.HttpException

interface ErrorHandler {
    /**
     * Method to call when Mdm server returns an error response.
     */
    suspend fun onHttpError(httpError: HttpException)

    /**
     * Method to call when any error that is not a Retrofit [HttpException] occurs
     */
    suspend fun onOtherError(error: Throwable)
}