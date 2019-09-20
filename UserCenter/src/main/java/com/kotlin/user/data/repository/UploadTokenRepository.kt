package com.kotlin.user.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UploadAip
import rx.Observable
import javax.inject.Inject

class UploadTokenRepository @Inject constructor() {

    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadAip::class.java).getUploadToken()
    }
}