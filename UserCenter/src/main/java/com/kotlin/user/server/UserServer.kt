package com.kotlin.user.server

import rx.Observable


interface UserServer {
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean>
}