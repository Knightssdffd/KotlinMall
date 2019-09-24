package com.kotlin.user.injection.module

import com.kotlin.user.service.UploadServer
import com.kotlin.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides


@Module
class UploadModule {
    @Provides
    fun providesUserService(uploadServer: UploadServiceImpl): UploadServer {
        return uploadServer
    }
}