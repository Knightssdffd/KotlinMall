package com.kotlin.user.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UserAip
import com.kotlin.user.data.protocol.RegisterReq
import rx.Observable

/**
 * Created by  幻忧 on  2019/9/9 13:23
 *  @function
 */
class UserRepository {
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserAip::class.java)
            .register(RegisterReq(mobile, pwd, verifyCode))
    }
}