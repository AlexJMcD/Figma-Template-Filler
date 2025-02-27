package com.amcd.figmatemplatefiller

import android.app.Application
import com.amcd.figmatemplatefiller.data.ExportFolderProvider
import com.amcd.figmatemplatefiller.data.di.dataModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.io.IOException

class MainApplication: Application() {
    private val exportFolderProvider by inject<ExportFolderProvider>()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            // Load modules
            modules(listOf(dataModule))
        }

        try {
            //TODO: Modify to only run on first app run.
            exportFolderProvider.generateRootFolder()
        } catch (e: IOException) {
            //TODO: Add error logging.
        }
    }
}