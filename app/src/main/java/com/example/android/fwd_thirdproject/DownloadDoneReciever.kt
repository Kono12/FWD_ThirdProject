package com.example.android.fwd_thirdproject

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import com.example.android.fwd_thirdproject.NotificationsHelper.createNotification


class DownloadDoneReciever( customButtonn: CustomButtonn):BroadcastReceiver() {
    val customButton=customButtonn
    @SuppressLint("Range")
    override fun onReceive(context:Context?, intent: Intent?) {
        val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1) ?: return

        customButton.buttonState = ButtonState.Completed


        val downloadManager = context!!.getSystemService(AppCompatActivity.DOWNLOAD_SERVICE) as DownloadManager

        val query = DownloadManager.Query()
        query.setFilterById(id!!)

        val cursor = downloadManager.query(query)

        if (cursor.moveToFirst()) {

            val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))

            var downloadStatus = "Fail"
            if (DownloadManager.STATUS_SUCCESSFUL == status)
                downloadStatus = "Success"

          Constants.st=downloadStatus
          //  Toast.makeText(context, downloadStatus, Toast.LENGTH_LONG).show()

            val notificationManager = context!!.getSystemService(NotificationManager::class.java)
            notificationManager.createNotification(
                context,"Downloading "+Constants.fileName,"Download State : " + downloadStatus,
                true,Constants.fileName,downloadStatus
            )
        }



    }
}