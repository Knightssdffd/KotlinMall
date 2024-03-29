package com.kotlin.user.injection.module

import com.kotlin.user.service.UserServer
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides


@Module
class UserModule {
    @Provides
    fun providesUserService(server: UserServiceImpl): UserServer {
        return server
    }
}