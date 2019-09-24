package com.kotlin.user.service

import rx.Observable

interface UploadServer {

    fun getUploadToken(): Observable<String>

}