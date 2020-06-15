/*
 *
 *  * Created by Murillo Comino on 15/06/20 17:32
 *  * Github: github.com/MurilloComino
 *  * StackOverFlow: pt.stackoverflow.com/users/128573
 *  * Email: murillo_comino@hotmail.com
 *  *
 *  * Copyright (c) 2020.
 *  * Last modified 15/06/20 17:31
 *
 */

package br.com.comino.handlepathoz.errors


open class HandlePathOzException(message: String, mErrorCode: Int) : RuntimeException(message) {
    protected companion object {
        const val UNKNOWN_DOCUMENT_PROVIDER = 3550
        const val EMPTY_GOOGLE_PHOTOS = 3551
        const val UNKNOWN_FILE_PATH = 3552
        const val UNKNOWN_EXCEPTION = 3553
    }

    val errorCode = mErrorCode
}

class UnknownDocumentsProviderException :
    HandlePathOzException(MESSAGE, UNKNOWN_DOCUMENT_PROVIDER) {
    companion object {
        private const val MESSAGE = "has unknown document provider"
    }
}

class EmptyGooglePhotosException(path: String) :
    HandlePathOzException("$MESSAGE $path", EMPTY_GOOGLE_PHOTOS) {
    companion object {
        private const val MESSAGE = "has empty google photos with path: "
    }
}

class UnknownFilePathException(path: String) :
    HandlePathOzException("$MESSAGE $path", UNKNOWN_FILE_PATH) {
    companion object {
        private const val MESSAGE = "has unknown file path with path: "
    }
}

class HandlePathOzUnknownException(path: String) :
    HandlePathOzException("$MESSAGE $path", UNKNOWN_EXCEPTION) {
    companion object {
        private const val MESSAGE = "has unknown exception with path: "
    }
}