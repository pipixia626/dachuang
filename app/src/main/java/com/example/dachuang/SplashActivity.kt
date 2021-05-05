package com.example.dachuang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

/**
 * 闪屏界面，应用程序首次启动入口
 *
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)


    }
}