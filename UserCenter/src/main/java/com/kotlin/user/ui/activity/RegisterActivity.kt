package com.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.base.common.AppManager
import com.kotlin.base.ext.enable
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.injection.componet.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 * 注册界面
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    private var pressTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }


    private fun initView() {
        mRegisterBtn.enable(mMobileEt) { isBtnEnable() }
        mRegisterBtn.enable(mVerifyCodeEt) { isBtnEnable() }
        mRegisterBtn.enable(mPwdEt) { isBtnEnable() }
        mRegisterBtn.enable(mPwdConfirmEt) { isBtnEnable() }

        mVerifyCodeBtn.setOnClickListener(this)
        mRegisterBtn.setOnClickListener(this)
    }


    override fun injectComponent() {
        DaggerUserComponent.builder().userModule(UserModule()).activityComponent(mActivityComponent)
            .build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 注册回调
     */
    override fun onRegisterResult(result: String) {
        toast(result)
    }


    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证码成功")
            }
            R.id.mRegisterBtn -> {
                mPresenter.register(
                    mMobileEt.text.toString(),
                    mVerifyCodeEt.text.toString(),
                    mPwdEt.text.toString()
                )
            }

        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }

}
