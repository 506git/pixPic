package com.example.pixpicapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PicApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}