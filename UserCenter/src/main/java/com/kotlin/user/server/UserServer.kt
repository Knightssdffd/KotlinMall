package com.kotlin.user.server

import com.kotlin.user.data.protocol.UserInfo
import rx.Observable


interface UserServer {

    fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean>

    fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo>

}