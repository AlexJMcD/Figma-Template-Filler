package com.amcd.figmatemplatefiller.data.api

import com.amcd.figmatemplatefiller.BuildConfig
import com.amcd.figmatemplatefiller.data.api.model.TemplateUrlResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Streaming
import retrofit2.http.Url

interface FigmaApi {

    @GET("v1/images/{file_key}")
    suspend fun getTemplateDownloadUrls(
        @Path("file_key") fileKey: String,           // File key from Figma
        @Query("ids") ids: List<String>,                  // Comma-separated list of node IDs
        @Query("format") format: String = "svg",    // Image format (default to SVG)
        @Query("svg_include_id") svgIncludeId: Boolean = false, // Optional: Include IDs in SVG
        @Header("X-Figma-Token") authHeader: String = BuildConfig.FIGMA_API_TOKEN
    ): Response<TemplateUrlResponse>

    @Streaming
    @GET
    suspend fun fetchTemplateSvg(@Url url: String): Response<ResponseBody>
}