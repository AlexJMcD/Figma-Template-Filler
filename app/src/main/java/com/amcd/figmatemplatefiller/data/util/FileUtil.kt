package com.amcd.figmatemplatefiller.data.util

import android.content.ContentResolver
import android.content.ContentValues
import android.provider.MediaStore

class FileUtil(
    private val contentResolver: ContentResolver
) {
    fun saveSvgToSharedStorage(
        fileName: String,
        saveFolderPath: String,
        svgByteStream: ByteArray
    ) {
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName) // File name
            put(MediaStore.MediaColumns.MIME_TYPE, "image/svg+xml") // File type
            put(MediaStore.MediaColumns.RELATIVE_PATH, "Pictures/MyApp") // Folder in Pictures
        }

        // Insert the file into the MediaStore
        val uri =
            contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)


        uri?.let { contentUri ->
            contentResolver.openOutputStream(contentUri)?.use { outputStream ->
                try {
                    outputStream.use {
                        it.write(svgByteStream)
                    }
                } catch (e:Exception) {
                    //TODO: Add error handling
                }
            }
        }
    }

}