package org.doubleprotein.mathilda.web

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import org.doubleprotein.mathilda.BuildConfig

/**
 * Author: 夏胜明
 * Date: 2018/9/25 0025
 * Email: xiasem@163.com
 * Description:
 */
class LoggingIntercaptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (BuildConfig.DEBUG) {
            Log.d("LoggingIntercaptor", "请求url--" + request.url().toString())
        }
        return chain.proceed(request)
    }

}