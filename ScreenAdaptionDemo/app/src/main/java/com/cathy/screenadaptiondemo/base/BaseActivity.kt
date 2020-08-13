package com.cathy.screenadaptiondemo.base

import android.app.Activity
import android.os.Bundle
import com.cathy.screenadaptiondemo.utils.DensityUtil
import com.cathy.screenadaptiondemo.utils.ScreenUtilJ
import com.cathy.screenadaptiondemo.utils.d


/**
+--------------------------------------+
+ @author Catherine Liu
+--------------------------------------+
+ 2020/8/5 19:36
+--------------------------------------+
+ Des: Activity 基类
+--------------------------------------+
 */

abstract class BaseActivity : Activity() {
    private val TAG: String = BaseActivity::class.java.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        DensityUtil.setDensity(application, this);
        setContentView(getLayoutRes())
        initView()
        initData()
        initListener()
        DensityUtil()
        d(
            TAG,
            "ScreenWidth:【" + ScreenUtilJ.getScreenWidth(this) + "】 ScreenHeight:【" + ScreenUtilJ.getScreenHeight(
                this
            ) + "】"
        )


    }

    /**
     * 获取当前的布局信息
     */
    abstract fun getLayoutRes(): Int

    /**
     * 初始化界面视图
     */
    abstract fun initView()

    /**
     * 初始化界面数据
     */
    abstract fun initData()

    /**
     * 初始化界面控件事件
     */
    abstract fun initListener()

    /**
     * 注册监听UI
     */
    abstract fun subscribeUI()
}