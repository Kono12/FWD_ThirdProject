package com.example.android.fwd_thirdproject

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DownloadDoneReciever:BroadcastReceiver() {
    override fun onReceive(context:Context?, intent: Intent?) {
        val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1) ?: return



    }
}