package org.doubleprotein.mathilda.user

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_register.*
import org.doubleprotein.mathilda.R
import org.doubleprotein.mathilda.base.Utils
import org.doubleprotein.mathilda.beans.DataResp
import org.doubleprotein.mathilda.beans.Register
import org.doubleprotein.mathilda.web.RetrofitSingleton
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initview()
    }

    private fun initview() {
        login.onClick {
            login(username.text.toString(), password.text.toString(), repassword.text.toString())
        }
    }

    private fun login(username : String, password : String, repassword : String) {
        if (Utils.isEmpty(username)) {
            toast("用户名不能为空！")
            return
        }
        if (Utils.isEmpty(password)) {
            toast("密码不能为空！")
            return
        }
        if (Utils.isEmpty(repassword)) {
            toast("密码不能为空！")
            return
        }
        if (!password.equals(repassword)) {
            toast("两次输入密码不一致！")
            return
        }

        RetrofitSingleton.api.register(username, password, repassword).enqueue(object : Callback<DataResp<Register>> {
            override fun onFailure(call: Call<DataResp<Register>>, t: Throwable) {
                toast("注册失败，原因未知！")
            }

            override fun onResponse(call: Call<DataResp<Register>>, response: Response<DataResp<Register>>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body!!.errorCode == 0) {
                        toast("注册成功！")


                    } else {
                        toast(body.errorMsg)
                    }
                } else{
                    toast("注册失败，原因未知！")
                }
            }

        })

    }
}
