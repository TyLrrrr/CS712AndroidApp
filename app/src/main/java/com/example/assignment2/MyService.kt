package com.example.assignment2

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings


class MyService : Service() {

    private var player: MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if (player == null) {
            player = MediaPlayer.create(
                this,
                Settings.System.DEFAULT_RINGTONE_URI
            )

            player?.isLooping = true
            player?.start()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        player?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release()
        }

        player = null
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}