package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.project.util.Util
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_roles.*
import kotlinx.android.synthetic.main.activity_setting_game.*

class RolesActivity2 : AppCompatActivity() {

    private val places = arrayOf(
        "В Беларуси",
        "В каменном веке",
        "В норе крота",
        "В кормане",
        "В холодильнике",
        "В Швейцарии",
        "В шоколаде",
        "В ночном клубе",
        "В Турции",
        "В университете",
        "В яме",
        "На даче",
        "В церкви",
        "На сцене",
        "В аэропорту",
        "На каникулах",
        "В диких джунглях",
        "В индийском фильме",
        "На острове",
        "В Китае",
        "В море",
        "В космосе",
        "На ринге",
        "В YouTube",
        "На карантине",
        "В джаз клубе",
        "На дискотеке",
        "На китайской стене",
        "У водопада",
        "В плену у испанцев",
        "В королевском дворце",
        "На свадьбе друга",
        "На мосту",
        "В музее",
        "В театре",
        "В библиотеке",
        "В подъезде",
        "На Марсе",
        "В Колизее",
        "В армии",
        "В Голливуде",
        "На крыше",
        "На корабле",
        "В приемной",
        "В Диснейленде",
        "В кино",
        "В парке",
        "В Африке",
        "На южном полюсе",
        "На Кавказе",
        "У бабушки в деревне"
    )

    private val places2 = arrayOf(
        "На набережной",
        "В ванной",
        "В деревне",
        "В диких джунглях",
        "На северном полюсе",
        "Во Франции",
        "На Кубе",
        "В баре",
        "В плену у немцев",
        "В пионерском лагере",
        "На войне",
        "В Сирии",
        "В Мексике",
        "В саду",
        "В самолете",
        "На болоте",
        "На Луне",
        "На рынке",
        "На рифах",
        "Под водой",
        "На дне океана",
        "На Титанике",
        "На шоу лучше всех",
        "На шоу давай поженимся",
        "У сцены",
        "На площади",
        "В подвале",
        "В оперном театре",
        "На рок концерте",
        "На авиабазе",
        "На Эвересте",
        "В Лувре",
        "В видеоигре",
        "В анатомичеком парке",
        "В лесу",
        "В Англии",
        "В спортзале",
        "На орбите Земли",
        "На кружке рукоделия",
        "В пещере",
        "На задней парте",
        "На заводе",
        "В фильме ужасов",
        "В Нарнии",
        "В ботаническом саду",
        "В средневековье",
        "В ЖЭУ",
        "На инопланетном корабле",
        "В суде",
        "В тюрьме",
        "В бункере"
    )

    private val place = places.random()
    private val spy = places2.random()
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
