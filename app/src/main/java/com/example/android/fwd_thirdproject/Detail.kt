package com.example.android.fwd_thirdproject

import android.app.NotificationManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class Detail : AppCompatActivity() {
    lateinit var fileNameTxt: TextView
    lateinit var statusTxt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        val notificationManager = getSystemService(NotificationManager::class.java)
//        notificationManager.cancelAll()

        setContentView(R.layout.activity_detail)
        fileNameTxt = findViewById(R.id.fileName)
        statusTxt = findViewById(R.id.state)
////
        val file = intent.getStringExtra("fileName")
        val statt = intent.getStringExtra("status")
//
//        val file=Constants.fileName
//        val statt=Constants.st

        //  Toast.makeText(applicationContext,file+statt,Toast.LENGTH_SHORT).show()

        fileNameTxt.text = file

        if (statt.equals("Success")) {
            statusTxt.text = "Successful"
            statusTxt.setTextColor(ContextCompat.getColor(applicationContext, R.color.green))
        } else {
            statusTxt.text = "Fail"
            statusTxt.setTextColor(ContextCompat.getColor(applicationContext, R.color.red))
        }

    }

    fun ClickedBTN(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}