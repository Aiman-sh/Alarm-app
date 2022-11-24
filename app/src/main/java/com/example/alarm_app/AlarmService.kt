package com.example.alarm_app

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build

class AlarmService(private val context:Context) {
    private val alarmManager:AlarmManager?=context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
    fun setExactAlarm(timeInMilliSec:Long){
        setAlarm(timeInMilliSec,
        getPendingIntent(
            getIntent().apply {
                action=Constants.ACTION_EXACT_ALARM
                putExtra(Constants.EXTRA_EXACT_ALARM_TIME,timeInMilliSec)
            }
        ))
    }
    fun setAlarm(timeInMilliSec:Long,pendingIntent:PendingIntent){
        alarmManager.let {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                alarmManager?.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    timeInMilliSec,
                    pendingIntent
                )

            }else{
                alarmManager?.setExact(
                    AlarmManager.RTC_WAKEUP,
                    timeInMilliSec,
                    pendingIntent
                )

            }
        }
    }
     fun getIntent() :Intent= Intent(context,MainActivity::class.java)
     fun getPendingIntent(intent: Intent) = PendingIntent.getBroadcast(
         context,
         0,
         intent,
         PendingIntent.FLAG_UPDATE_CURRENT
     )
}