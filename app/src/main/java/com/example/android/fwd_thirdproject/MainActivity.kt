package com.example.android.fwd_thirdproject

import android.app.DownloadManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var option : String? =""
    var filename : String? =""
    lateinit var receiver: DownloadDoneReciever
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        receiver = DownloadDoneReciever()
        IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE).also {
            registerReceiver(receiver,it)
        }



    }

    fun ChoeseOperation(view: View) {
         if (view is RadioButton && view.isChecked){
           if (view.id==R.id.Glide){
               option=Constants.GLIDE_URL
           filename="Glide"
           }
             else if(view.id==R.id.Load){
                 option=Constants.LOAD_APP_URL
             filename="Load App"
             }
             else if (view.id==R.id.Retro){
                 option=Constants.RETROFIT_URL
             filename="Retrofit"
             }
         }
    }

    fun ButtonOnClick(view: View) {
       // Toast.makeText(this,DownloadManager.Request.VISIBILITY_HIDDEN.toString(),Toast.LENGTH_SHORT).show()
        download(option)
    }

    private fun download(optionSelected : String?) {
        try{
                val download = DownloadManager.Request(Uri.parse(optionSelected))
                    .setTitle(getString(R.string.app_name))
                    .setDescription(filename)
                    .setAllowedOverRoaming(true)
                    .setRequiresCharging(false)
                    .setAllowedOverMetered(true)

                val downloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
                Constants.downloadId =
                    downloadManager.enqueue(download)

        }catch (E : Exception){
            Toast.makeText(this,"Chose one",Toast.LENGTH_SHORT).show()
        }
    }



    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}

