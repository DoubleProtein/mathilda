package org.doubleprotein.mathilda.base

import android.text.TextUtils
import android.util.Log

/**
 * Author: 夏胜明
 * Date: 2018/9/25 0025
 * Email: xiasem@163.com
 * Description:
 */
object Utils {
    fun isEmpty(string: String) : Boolean {
        return TextUtils.isEmpty(string)
    }

    fun logd(tag : String, message: String) {
        Log.d(tag, message)
    }
}