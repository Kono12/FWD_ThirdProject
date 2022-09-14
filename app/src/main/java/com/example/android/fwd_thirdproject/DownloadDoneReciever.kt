package com.example.android.fwd_thirdproject

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast




class DownloadDoneReciever:BroadcastReceiver() {
    override fun onReceive(context:Context?, intent: Intent?) {
        val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1) ?: return

        //Checking if the received broadcast is for our enqueued download by matching download id
        if (Constants.downloadId == id) {
            Toast.makeText(context, "Download Completed", Toast.LENGTH_SHORT).show()
            //todo:Make Notification
        }



    }
}