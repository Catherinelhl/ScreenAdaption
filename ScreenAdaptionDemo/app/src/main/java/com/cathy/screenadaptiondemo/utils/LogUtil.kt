package com.cathy.screenadaptiondemo.utils

import android.util.Log

/**
+--------------------------------------+
+ @author Catherine Liu
+--------------------------------------+
+ 2020/8/10 14:31
+--------------------------------------+
+ Des:日志输入工具类
+--------------------------------------+
 */


fun v(tag: String, info: String) {
    Log.v(tag, info)
}

fun i(tag: String, info: String) {
    Log.i(tag, info)
}

fun d(tag: String, info: String) {
    Log.d(tag, info)
}

fun w(tag: String, info: String) {
    Log.w(tag, info)
}

fun e(tag: String, info: String) {
    Log.e(tag, info)
}
