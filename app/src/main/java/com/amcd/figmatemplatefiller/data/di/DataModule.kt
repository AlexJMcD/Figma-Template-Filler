package com.amcd.figmatemplatefiller.data.di

import com.amcd.figmatemplatefiller.data.api.FigmaApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {
    factory<FigmaApi> {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("")
            .build()
            .create(FigmaApi::class.java)
    }
}