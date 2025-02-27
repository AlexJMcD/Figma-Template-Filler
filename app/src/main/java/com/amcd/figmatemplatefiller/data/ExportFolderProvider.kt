package com.amcd.figmatemplatefiller.data

import android.os.Environment
import java.io.File
import java.io.IOException
import kotlin.jvm.Throws

class ExportFolderProvider(
    private val root: File = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_PICTURES + "/$APP_FOLDER_ROOT/"
    )
) {
    /**
     * Creates the root folder for files exported by this application.
     */
    @Throws(IOException::class)
    fun generateRootFolder(){
        root.mkdirs()
    }

    /**
     * Creates a sub folder for all exports associated with a specific template.
     */
    @Throws(IOException::class)
    fun generateTemplateFolder(folderName: String): String {
        val newFolder = File(root, folderName)
        newFolder.mkdirs()
        return newFolder.absolutePath
    }

    val exports: File = File(root, EXPORT)

    companion object {
        private const val APP_FOLDER_ROOT = "figma_template_filler"
        private const val EXPORT = "export"
    }
}