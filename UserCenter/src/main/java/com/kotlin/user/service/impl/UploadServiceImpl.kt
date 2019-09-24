package com.kotlin.user.service.impl


import com.kotlin.base.ext.convert
import com.kotlin.user.data.repository.UploadTokenRepository
import com.kotlin.user.service.UploadServer
import rx.Observable
import javax.inject.Inject


class UploadServiceImpl @Inject constructor() : UploadServer {

    @Inject
    lateinit var repository: UploadTokenRepository
    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }
}