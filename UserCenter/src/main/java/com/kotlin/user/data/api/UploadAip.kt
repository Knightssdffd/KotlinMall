package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.*
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by  幻忧 on  2019/9/9 13:15
 *  @function
 */
interface UploadAip {
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}