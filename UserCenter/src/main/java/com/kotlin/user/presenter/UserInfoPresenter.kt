package com.kotlin.user.presenter

import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.presenter.view.UserInfoView
import com.kotlin.user.server.UploadServer
import com.kotlin.user.server.UserServer
import javax.inject.Inject

class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var uploadServer: UploadServer
    @Inject
    lateinit var userService: UserServer


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

    fun editUser(userIcon: String, userName: String, userGender: String, userSign: String) {
        if (!checkNetWork())
            return
        mView.showLoading()
        userService.editUser(userIcon, userName, userGender, userSign)
            .excute(object : BaseSubscriber<UserInfo>(mView) {
                override fun onNext(t: UserInfo) {
                    super.onNext(t)

                }
            }, lifecycleProvider)


    }

}