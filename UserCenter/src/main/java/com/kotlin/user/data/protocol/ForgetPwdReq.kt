package com.kotlin.user.data.protocol

/**
 * Created by  幻忧 on  2019/9/9 13:17
 *  @function
 */

data class ForgetPwdReq(
    val mobile: String,
    val verifyCode: String
)
