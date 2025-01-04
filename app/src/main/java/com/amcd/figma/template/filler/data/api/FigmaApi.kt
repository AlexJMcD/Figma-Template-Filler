package com.amcd.figma.template.filler.data.api

import com.amcd.figma.template.filler.data.api.model.TemplateUrlResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface FigmaApi {

    @GET
    fun getTemplateDownloadUrls(@Url url: String): Response<TemplateUrlResponse>

    @GET
    fun fetchTemplateSvg(@Url url: String): Response<ResponseBody>
}