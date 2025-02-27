package com.amcd.figmatemplatefiller.data.api.apicallhandlers

import com.amcd.figmatemplatefiller.data.ExportFolderProvider
import com.amcd.figmatemplatefiller.data.api.FigmaApi
import com.amcd.figmatemplatefiller.data.api.errorhandler.ErrorHandler
import com.amcd.figmatemplatefiller.data.api.util.makeApiCall
import com.amcd.figmatemplatefiller.data.util.FileUtil

class ImageDownloadHandler(
    private val errorHandler: ErrorHandler,
    private val figmaApi: FigmaApi,
    private val fileUtil: FileUtil,
    private val exportFolderProvider: ExportFolderProvider
) {
    suspend fun downloadAndSaveImage(imageUrl: String, templateName: String, fileId: String) {
        val downloadResponse = makeApiCall(
            errorHandler = errorHandler
        ) {
            figmaApi.fetchTemplateSvg(url = imageUrl)
        }

        downloadResponse?.let { response ->
            val saveFolderPath =
                exportFolderProvider.generateTemplateFolder(folderName = templateName)

            fileUtil.saveSvgToSharedStorage(
                fileName = fileId,
                saveFolderPath = saveFolderPath,
                svgByteStream = response.bytes()
            )
        }
    }
}