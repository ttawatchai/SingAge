package com.example.n007.signage

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.example.n007.signage.model.Info.content
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.media.MediaPlayer.OnPreparedListener


class MainActivity : AppCompatActivity() {
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    var contentList: MutableList<content> = arrayListOf()
    var path = "android.resource://com.example.n007.signage/" + R.raw.vdo1
    var count: Int = 0
    var time: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)


        mHandler = Handler()
        addData()
        setTime()
    }

    @SuppressLint("SetTextI18n")
    private fun setTime() {
        mRunnable = Runnable {
            val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            val currentMin = Calendar.getInstance().get(Calendar.MINUTE)
            val currentSec = Calendar.getInstance().get(Calendar.SECOND)
            tv_time.text = currentHour.toString() + ":" + currentMin.toString() + ":" + currentSec.toString()
            checkTimeTest()
            mHandler.postDelayed(
                    mRunnable, // Runnable
                    1000 // Delay in milliseconds
            )
        }
        mHandler.postDelayed(
                mRunnable, // Runnable
                1000 // Delay in milliseconds
        )
    }

    private fun addData() {
        contentList.add(content("pic1", "pic", "11:43:1"))
        contentList.add(content("pic2", "pic", "11:44:2"))
        contentList.add(content("pic3", "pic", "11:47:3"))
        contentList.add(content("vdo", "vdo", "11:45:4"))
    }

    @SuppressLint("ResourceType")
    private fun checkTime() {
        for (i in contentList) {
            if (tv_time.text.toString() == i._time) {
                var id = resources.getIdentifier(i._name, "raw", packageName)
                if (i._type.equals("vdo")) {
                    show_img.visibility = View.GONE
                    show_vdo.visibility = View.VISIBLE
                    show_vdo.setVideoPath(path)
                    show_vdo.start()
                } else if (i._type.equals("pic")) {
                    show_vdo.visibility = View.GONE
                    show_img.visibility = View.VISIBLE
                    show_img.setImageResource(id)

                }
            }
        }

    }

    @SuppressLint("ResourceType")
    private fun checkTimeTest() {
        Log.d("pic", time.toString() + "count" + count)
        count++
        if (time == contentList.size) {
            time = 0
        }

        if (count == 30 || count == 0) {
            count = 0
            var id = resources.getIdentifier(contentList.get(time)._name, "raw", packageName)
            if (contentList.get(time)._type.equals("vdo")) {
                show_img.visibility = View.GONE
                show_vdo.visibility = View.VISIBLE
                show_vdo.setOnPreparedListener { mp -> mp.isLooping = true }
                show_vdo.setVideoPath(path)
                show_vdo.start()

            } else if (contentList.get(time)._type.equals("pic")) {
                show_vdo.visibility = View.GONE
                show_img.visibility = View.VISIBLE
                show_img.setBackgroundResource(id)

            }
            time++

        }

    }


}

