package com.msm.msmtodo

import android.app.Application
import com.msm.msmtodo.data.AppContainer
import com.msm.msmtodo.data.DefaultAppContainer

class TodoNotesApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}