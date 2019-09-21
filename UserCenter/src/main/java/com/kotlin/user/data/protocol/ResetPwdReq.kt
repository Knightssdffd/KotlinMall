package com.kotlin.user.data.protocol

/**
 * Created by  幻忧 on  2019/9/9 13:17
 *  @function
 */
data class ResetPwdReq(
    val mobile: String,
    val pwd: String
)
