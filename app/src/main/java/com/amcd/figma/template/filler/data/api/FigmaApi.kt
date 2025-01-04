package com.amcd.figma.template.filler.data.api

import retrofit2.http.GET

interface FigmaApi {

    @GET
    fun getTemplateSvg() {
    }
}