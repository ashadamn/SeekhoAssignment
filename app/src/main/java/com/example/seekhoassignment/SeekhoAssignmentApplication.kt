package com.example.seekhoassignment

import android.app.Application
import com.example.seekhoassignment.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SeekhoAssignmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SeekhoAssignmentApplication)
            modules(appModule)
        }
    }

}