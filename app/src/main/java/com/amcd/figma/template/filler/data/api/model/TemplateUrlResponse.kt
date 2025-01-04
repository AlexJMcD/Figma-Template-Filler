package com.amcd.figma.template.filler.data.api.model

import com.squareup.moshi.Json

/**
 * API response object when fetching figma download URLS.
 * @param error An error message with additional information on what went wrong.
 * @param images A map containing download URLs for generated images.
 * @param status An http status code.
 */
data class TemplateUrlResponse(
    @Json(name = "err")
    val error: String?,
    @Json(name = "images")
    val images: Map<String, String?>,
    @Json(name = "status")
    val status: Number?
)
