package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runOnUiThread {
            Handler().postDelayed({
                image_message_1.visibility = View.VISIBLE
            }, 2000)

            Handler().postDelayed({
                image_message_1.visibility = View.GONE
                image_message_2.visibility = View.VISIBLE
            }, 4000)
        }

        enter_btn.setOnClickListener {
            intent = Intent(this, SettingGame::class.java)
            startActivity(intent)
            finish()
        }
    }
}

