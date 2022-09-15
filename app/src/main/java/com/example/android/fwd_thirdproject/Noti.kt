package com.example.android.fwd_thirdproject

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

private const val NOTIFICATION_ID = 0
private const val REQUEST_CODE = 0
private const val FLAGS = 0


// May need to pass notification Id as a arg here.
fun NotificationManager.sendNotification2( context: Context, title: String, message: String,
                                           autoCancel: Boolean, fileName: String, status: String) {

    val contentIntent = Intent(context, Detail::class.java)
    contentIntent.apply {
        putExtra("fileName", fileName)
        putExtra("status", status)
    }

    val contentPendingIntent =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        PendingIntent.getActivity(context, 0, contentIntent, PendingIntent.FLAG_MUTABLE)
    } else {
        PendingIntent.getActivity(
            context,
            0,
            contentIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }


      //  PendingIntent.getActivity(context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT)

    val action = NotificationCompat.Action.Builder(0,"Show Details",contentPendingIntent).build()
    val notificationBuilder = NotificationCompat.Builder(context, "context.getString(R.string.notification_channel_id)")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("Download Complete")
        .setContentText("messageBody")
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(autoCancel)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .addAction(action)

    notify(NOTIFICATION_ID, notificationBuilder.build())
}