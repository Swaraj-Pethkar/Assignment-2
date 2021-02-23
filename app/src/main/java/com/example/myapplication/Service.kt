package com.example.myapplication

import android.app.Service
import android.content.ContentResolver
import android.content.ContentResolver.SCHEME_ANDROID_RESOURCE
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast
import java.io.File
import java.io.File.pathSeparator
import java.io.File.separator


class Service : Service() {

    private var isRunning = false
    private val player: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        // TODO Auto-generated method stub
        return null
    }

    override fun onCreate() {
        Toast.makeText(this, " MyService Created ", Toast.LENGTH_LONG).show()
        isRunning = true;
    }



    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        var player = MediaPlayer.create(this,
//            getRawUri("tdkr.mp3"));
//        player.setLooping(true);
        Toast.makeText(this, " MyService Started", Toast.LENGTH_LONG).show()
        return START_STICKY
    }

    fun getRawUri(filename: String): Uri? {
        return Uri.parse(SCHEME_ANDROID_RESOURCE + pathSeparator + separator.toString() + packageName.toString() + "/raw/" + filename)
    }

    override fun onDestroy() {
        super.onDestroy();
        isRunning = false
        Toast.makeText(this, "MyService Completed or Stopped.", Toast.LENGTH_SHORT).show()
    }
}