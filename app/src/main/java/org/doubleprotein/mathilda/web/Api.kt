package org.doubleprotein.mathilda.web

import org.doubleprotein.mathilda.beans.Article
import org.doubleprotein.mathilda.beans.DataResp
import org.doubleprotein.mathilda.beans.Register
import retrofit2.Call
import retrofit2.http.*

/**
 * Author: 夏胜明
 * Date: 2018/9/25 0025
 * Email: xiasem@163.com
 * Description:
 */
interface Api {
    /**
     * 首页文章列表
     */
    @GET("article/list/{page}/json")
    fun homePageArticle(@Path("page") page: Int) : Call<DataResp<Article>>


    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("username") username : String, @Field("password") password : String, @Field("repassword") repassword : String) : Call<DataResp<Register>>


}