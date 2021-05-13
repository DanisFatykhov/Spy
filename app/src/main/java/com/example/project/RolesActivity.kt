package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.project.util.Util
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_roles.*
import kotlinx.android.synthetic.main.activity_setting_game.*

class RolesActivity : AppCompatActivity() {

    private val places = arrayOf(
        "В Уфе",
        "В туалете",
        "В кирпичном доме",
        "В норе",
        "В холодильнике",
        "В Швейцарии",
        "В шоколаде",
        "В байкерском баре",
        "В надежных руках",
        "В школе",
        "В посольстве",
        "В Америке",
        "На балконе",
        "В Колезее",
        "На авиабазе",
        "На каникулах",
        "На азиатском рынке",
        "На острове",
        "В лесу",
        "На Кубе",
        "В космосе",
        "На ринге",
        "В YouTube",
        "В джаз клубе",
        "На дискотеке",
        "На набережной",
        "В ванной",
        "В деревне",
        "В диких джунглях",
        "На северном полюсе",
        "Во Франции",
        "В море",
        "В баре",
        "В плену у немцев",
        "В пионерском лагере",
        "На войне",
        "В Сирии",
        "На даче",
        "В саду",
        "В самолете",
        "На болоте",
        "На луне",
        "На рынке",
        "На рифах",
        "Под водой",
        "На дне океана",
        "На Титанике",
        "На шоу Лучше всех",
        "На шоу Давай поженимся",
        "На карантине",
        "На Эвересте"
    )
    private val spy = "Ты шпион"
    private val place = places.random()
    private var player = 1
    private var players: Int = 4
    private lateinit var randomSpy: IntRange
    private var youSpy: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roles)

        var intent = intent

        if (intent.hasExtra("Players")) {
            players = intent.extras!!.getInt("Players")
            randomSpy = player..players
            youSpy = randomSpy.random()
        }

        runOnUiThread {
            next_bnt.visibility = View.VISIBLE
            spy_images.visibility = View.VISIBLE
            ok_bnt.visibility = View.GONE
            roles.visibility = View.GONE

            next_bnt.setOnClickListener {
                next_bnt.visibility = View.GONE
                spy_images.visibility = View.GONE
                ok_bnt.visibility = View.VISIBLE
                roles.visibility = View.VISIBLE
                if (player == youSpy) {
                    roles.text = spy
                } else {
                    roles.text = place
                }
                if (player == players) {
                    ok_bnt.visibility = View.GONE
                    start_bnt.visibility = View.VISIBLE
                }

                ok_bnt.setOnClickListener {
                    player++
                    roles.visibility = View.GONE
                    spy_images.visibility = View.VISIBLE
                    next_bnt.visibility = View.VISIBLE
                    ok_bnt.visibility = View.GONE
                }
            }
        }

        start_bnt.setOnClickListener {
            intent = Intent(this, TimerActivity::class.java)
            startActivity(intent)
        }
    }
}
