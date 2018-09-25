package org.doubleprotein.mathilda.web

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author: 夏胜明
 * Date: 2018/9/25 0025
 * Email: xiasem@163.com
 * Description:
 */
object RetrofitSingleton {
    val BASE_URL : String = "http://www.wanandroid.com"
    val api : Api = initApi(BASE_URL)

    private fun initApi(baseUrl : String) : Api {
        val client = OkHttpClient().newBuilder().apply {
            connectTimeout(30L, TimeUnit.SECONDS)
            readTimeout(30L, TimeUnit.SECONDS)
            addInterceptor(LoggingIntercaptor())
        }.build()
        return Retrofit.Builder().apply {
            baseUrl(baseUrl)
            client(client)
            addConverterFactory(GsonConverterFactory.create())
        }.build().create(Api::class.java)
    }


}