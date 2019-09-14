package com.kotlin.user.injection.componet

import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.ui.activity.RegisterActivity
import dagger.Component


@Component(modules = [UserModule::class])
interface UserComponent {

    fun inject(activity: RegisterActivity)
}