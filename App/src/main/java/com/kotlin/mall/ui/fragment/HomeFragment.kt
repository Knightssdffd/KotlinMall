package com.kotlin.mall.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.widgets.BannerImageLoader
import com.kotlin.mall.R
import com.kotlin.mall.common.*
import com.kotlin.mall.ui.adapter.HomeDiscountAdapter
import com.kotlin.mall.ui.adapter.TopicAdapter
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*
import me.crosswall.lib.coverflow.CoverFlow

class HomeFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
        initNews()
        initDiscount()
        initTopic()
    }

    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(
            listOf(
                HOME_BANNER_ONE,
                HOME_BANNER_TWO,
                HOME_BANNER_THREE,
                HOME_BANNER_FOUR
            )
        )
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        mHomeBanner.start()
    }

    private fun initNews() {
        //公告
        mNewsFlipperView.setData(arrayOf("夏日炎炎，第一波父类啊啊啊啊·1", "不不不不不不不不"))
    }

    private fun initDiscount() {
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager

        val discountAdapter = HomeDiscountAdapter(this.activity!!)
        mHomeDiscountRv.adapter = discountAdapter
        discountAdapter.setData(
            mutableListOf(
                HOME_DISCOUNT_ONE,
                HOME_DISCOUNT_TWO,
                HOME_DISCOUNT_THREE,
                HOME_DISCOUNT_FOUR,
                HOME_DISCOUNT_FIVE
            )
        )
    }

    private fun initTopic() {
        //话题
        mTopicPager.adapter = TopicAdapter(
            this.context!!,
            listOf(
                HOME_TOPIC_ONE,
                HOME_TOPIC_TWO,
                HOME_TOPIC_THREE,
                HOME_TOPIC_FOUR,
                HOME_TOPIC_FIVE
            )
        )
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5
        CoverFlow.Builder().with(mTopicPager).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f)
            .build()
    }

}