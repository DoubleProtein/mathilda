package org.doubleprotein.mathilda.beans

/**
 * Author: 夏胜明
 * Date: 2018/9/25 0025
 * Email: xiasem@163.com
 * Description:
 */

/**
 * retrofit 接收json解析的基类
 */
data class DataResp<T> (val errorMsg: String, val errorCode: Int, var data:T)

/**
 * 文章
 */
data class Article (
        val apkLink: String,
        val author: String,
        val chapterId: Int,
        val chapterName: String,
        val collect: Boolean,
        val desc: String,
        val id: Long,
        val link: String,
        val niceDate: String,
        val publishTime: Long,
        val superChapterId: Long,
        val superChapterName: String,
        val title: String,
        val type: Int,
        val userId: Long,
        val visible: Boolean,
        val zan: Int
)

data class Register (
        val a : String
)

