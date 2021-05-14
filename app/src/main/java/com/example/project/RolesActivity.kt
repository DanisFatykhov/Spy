package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.project.data.Place
import kotlinx.android.synthetic.main.activity_roles.*

class RolesActivity : AppCompatActivity() {

    private var player = 1
    private var players: Int = 4
    private lateinit var randomSpy: IntRange
    private var youSpy: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roles)

        val place = Place(this)
        val playerPlace = place.getPlayerPlaceForRoles1()

        var intent = intent

        if (intent.hasExtra("Players")) {
            players = intent.extras!!.getInt("Players")
            randomSpy = player..players
            youSpy = randomSpy.random()
        }

        runOnUiThread {
            startDistribution()

            next_bnt.setOnClickListener {
                nextDistribution()

                if (player == youSpy) {
                    roles.text = "Ты шпион"
                } else {
                    roles.text = playerPlace
                }
                if (player == players) {
                    ok_bnt.visibility = View.GONE
                    start_bnt.visibility = View.VISIBLE
                }

                ok_bnt.setOnClickListener {
                    player++
                    okDistribution()
                }
            }
        }

        start_bnt.setOnClickListener {
            intent = Intent(this, TimerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startDistribution() {
        next_bnt.visibility = View.VISIBLE
        spy_images.visibility = View.VISIBLE
        ok_bnt.visibility = View.GONE
        roles.visibility = View.GONE
    }

    private fun nextDistribution() {
        next_bnt.visibility = View.GONE
        spy_images.visibility = View.GONE
        ok_bnt.visibility = View.VISIBLE
        roles.visibility = View.VISIBLE
    }

    private fun okDistribution() {
        roles.visibility = View.GONE
        spy_images.visibility = View.VISIBLE
        next_bnt.visibility = View.VISIBLE
        ok_bnt.visibility = View.GONE
    }
}


