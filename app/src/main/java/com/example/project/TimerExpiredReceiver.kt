package com.example.project

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.project.util.Util

class TimerExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Util.setTimerState(TimerActivity.TimerState.Stopped, context)
        Util.setAlarmSetTime(0, context)
    }
}