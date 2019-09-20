package com.kotlin.user.server

import rx.Observable

interface UploadServer {

    fun getUploadToken(): Observable<String>

}