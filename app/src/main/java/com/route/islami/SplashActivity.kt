package com.route.islami

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.route.islami.main_fragments.main_activity.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent1 = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent1)
            finish()
        }, 2000)
    }
}