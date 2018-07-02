package com.example.n007.signage

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mHandler = Handler()
        setTime()
    }

    @SuppressLint("SetTextI18n")
    private fun setTime() {
        mRunnable = Runnable {
            val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            val currentMin = Calendar.getInstance().get(Calendar.MINUTE)
            val currentSec = Calendar.getInstance().get(Calendar.SECOND)
            tv_time.text = currentHour.toString()+":"+currentMin.toString()+":"+currentSec.toString()
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


}
