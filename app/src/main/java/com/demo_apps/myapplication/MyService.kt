package com.demo_apps.myapplication
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock

class MyService : Service() {

    private val binder = LocalBinder()
    private var startTime = 0L
    private var isRunning = false

    inner class LocalBinder : Binder() {
        fun getService(): MyService = this@MyService
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    fun startTimer() {
        if (!isRunning) {
            startTime = SystemClock.elapsedRealtime()
            isRunning = true
        }
    }

    fun getElapsedSeconds(): Long {
        return if (isRunning) {
            (SystemClock.elapsedRealtime() - startTime) / 1000
        } else {
            0L
        }
    }

    fun stopTimer() {
        isRunning = false
        startTime = 0L
    }
}