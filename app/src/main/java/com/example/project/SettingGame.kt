package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_setting_game.*

class SettingGame : AppCompatActivity() {

    var players: Int = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_game)

        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                player_length.text = "$progress чел"
                if (progress == 0) progress == 4 else players = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        game_bnt_1.setOnClickListener {
            val intent = Intent(this, RolesActivity::class.java)
            intent.putExtra("Players", players)
            startActivity(intent)
        }

        game_bnt_2.setOnClickListener {
            val intent = Intent(this, RolesActivity2::class.java)
            intent.putExtra("Players", players)
            startActivity(intent)
        }
    }
}
