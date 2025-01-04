package com.amcd.figmatemplatefiller.data.api.util

import com.amcd.figmatemplatefiller.data.api.errorhandler.ErrorHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

/**
 * Makes an API call, with error handling that expects a json object to be part of the response.
 */
suspend inline fun <T> makeApiCall(
    errorHandler: ErrorHandler,
    crossinline apiCall: suspend () -> Response<T>
): T? {
    return try {
        withContext(Dispatchers.IO) {
            val response = apiCall()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    } catch (e: HttpException) {
        errorHandler.onHttpError(e)
        null
    } catch (t: Throwable) {
        errorHandler.onOtherError(t)
        null
    }
}