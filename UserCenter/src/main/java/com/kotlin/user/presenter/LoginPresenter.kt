package com.kotlin.user.presenter

import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.presenter.view.LoginView
import com.kotlin.user.service.UserServer
import javax.inject.Inject

class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserServer

    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile,pwd, pushId).excute(object :BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                super.onNext(t)
                mView.onLoginResult(t)
            }
        },lifecycleProvider)

    }
}