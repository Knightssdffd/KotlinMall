package com.kotlin.user.presenter

import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.UserInfoView
import com.kotlin.user.server.UploadServer
import com.kotlin.user.server.UserServer
import javax.inject.Inject

class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var uploadServer: UploadServer


    fun getUploadToken() {
        if (!checkNetWork())
            return
        mView.showLoading()
        uploadServer.getUploadToken().excute(object : BaseSubscriber<String>(mView) {
            override fun onNext(t: String) {
                super.onNext(t)
                mView.onGetUploadTokenResult(t)
            }
        }, lifecycleProvider)
    }


}