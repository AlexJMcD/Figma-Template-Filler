package com.amcd.figma.template.filler.data.api.errorhandler

import retrofit2.HttpException

class AppErrorHandler: ErrorHandler {
    override suspend fun onHttpError(httpError: HttpException) {
        TODO("Not yet implemented")
    }


    override suspend fun onOtherError(error: Throwable) {
        TODO("Not yet implemented")
    }
}