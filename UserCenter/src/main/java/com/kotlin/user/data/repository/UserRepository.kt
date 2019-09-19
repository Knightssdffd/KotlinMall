package com.kotlin.user.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UserAip
import com.kotlin.user.data.protocol.*
import rx.Observable
import javax.inject.Inject

/**
 * Created by  幻忧 on  2019/9/9 13:23
 *  @function
 */
class UserRepository @Inject constructor() {
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserAip::class.java)
            .register(RegisterReq(mobile, pwd, verifyCode))
    }


    fun login(mobile: String, pwd: String, pushId: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instance.create(UserAip::class.java)
            .login(LoginReq(mobile, pwd, pushId))
    }


    fun forgetPwd(mobile: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserAip::class.java).forgetPwd(ForgetPwdReq(mobile, verifyCode))
    }

    fun resetPwd(mobile: String, pwd: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserAip::class.java).resetPwd(ResetPwdReq(mobile, pwd))
    }

}