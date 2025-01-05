package com.amcd.figmatemplatefiller.data.di

import com.amcd.figmatemplatefiller.data.api.FigmaApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {
    factory<FigmaApi> {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(getMoshi()))
            .baseUrl("https://api.figma.com")
            .build()
            .create(FigmaApi::class.java)
    }
}

// An instance of the MoshiConverterFactory that utilises the Json adapter from moshi-kotlin.
fun getMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()