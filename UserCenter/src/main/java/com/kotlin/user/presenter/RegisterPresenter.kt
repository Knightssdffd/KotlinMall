package com.kotlin.user.presenter

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.user.presenter.view.RegisterView

class RegisterPresenter : BasePresenter<RegisterView>() {


    fun register(mobile: String, verifyCode: String) {
        mView.onRegisterResult(true)
    }


}