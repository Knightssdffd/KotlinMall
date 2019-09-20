package com.kotlin.user.injection.module

import com.kotlin.user.server.UploadServer
import com.kotlin.user.server.UserServer
import com.kotlin.user.server.impl.UploadServiceImpl
import com.kotlin.user.server.impl.UserServiceImpl
import dagger.Module
import dagger.Provides


@Module
class UploadModule {
    @Provides
    fun providesUserService(uploadServer: UploadServiceImpl): UploadServer {
        return uploadServer
    }
}