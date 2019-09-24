package com.kotlin.user.presenter

import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.ForgetPwdView
import com.kotlin.user.service.UserServer
import javax.inject.Inject

class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {
    @Inject
    lateinit var userService: UserServer

    fun forgetPwd(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.forgetPwd(mobile, pwd)
            .excute(object : BaseSubscriber<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    super.onNext(t)
                    if (t)
                        mView.onForgetPwdResult("验证成功")
                }
            }, lifecycleProvider)
    }
}