package com.example.alarm_app

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var setAlarmButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAlarmButton = findViewById(R.id.btn_setAlarm)

    }
    fun setAlarm(){
        Calendar.getInstance().apply {
            DatePickerDialog(
                applicationContext,
                0,
                DatePickerDialog.OnDateSetListener { datePicker, year, month,day ->

                },
                this.get(Calendar.YEAR),
                this.get(Calendar.MONTH),
                this.get(Calendar.DAY_OF_MONTH)

            )
        }
    }

    private fun DatePickerDialog(calendar: Calendar, i: Int, onDateSetListener: DatePickerDialog.OnDateSetListener) {

    }
}