package com.kotlin.user.server.impl

import com.kotlin.user.server.UserServer
import rx.Observable


class UserServiceImpl : UserServer {
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return Observable.just(true)
    }
}