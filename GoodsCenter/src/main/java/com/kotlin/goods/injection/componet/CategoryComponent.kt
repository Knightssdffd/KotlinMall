package com.kotlin.goods.injection.componet

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.goods.injection.module.CategoryModule
import com.kotlin.goods.ui.fragment.CategoryFragment
import dagger.Component

/*
    商品分类Component
 */
@PerComponentScope
@Component(dependencies = [ActivityComponent::class],modules = [CategoryModule::class])
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}
