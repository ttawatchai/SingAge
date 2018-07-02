package com.example.n007.signage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import com.example.n007.signage.model.Info
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    val client = OkHttpClient()
    var content: Info.content? = null
    var sdf = SimpleDateFormat("ddMMyyyy")
    val currentTime = Calendar.getInstance().time
    var currentDate = sdf.format(Date())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun run(url: String) {
        val request = Request.Builder()
                .url(url)
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()
                content = gson.fromJson(body, Info.content::class.java)
                initView()
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }

    private fun initView() {
        tv_date.text = currentDate
        tv_time.text = currentTime.toString()
    }

}
