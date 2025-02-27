package com.amcd.figmatemplatefiller.data.di

import com.amcd.figmatemplatefiller.data.ExportFolderProvider
import com.amcd.figmatemplatefiller.data.api.FigmaApi
import com.amcd.figmatemplatefiller.data.api.apicallhandlers.ImageDownloadHandler
import com.amcd.figmatemplatefiller.data.api.errorhandler.AppErrorHandler
import com.amcd.figmatemplatefiller.data.api.errorhandler.ErrorHandler
import com.amcd.figmatemplatefiller.data.util.FileUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    // File handling components
    factory { ExportFolderProvider() }
    factory { FileUtil(contentResolver = androidContext().contentResolver) }

    // Network Components
    factory<ErrorHandler> { AppErrorHandler() }

    factory<FigmaApi> {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(getMoshi()))
            .baseUrl("https://api.figma.com")
            .build()
            .create(FigmaApi::class.java)
    }

    factory {
        ImageDownloadHandler(
            errorHandler = get(),
            figmaApi = get(),
            fileUtil = get(),
            exportFolderProvider = get()
        )
    }
}

// An instance of the MoshiConverterFactory that utilises the Json adapter from moshi-kotlin.
fun getMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()