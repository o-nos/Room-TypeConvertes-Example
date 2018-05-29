package com.rembedded.noso.rembeddedfieldsoom

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase


class App: Application() {

    companion object {

        lateinit var appDatabase: AppDatabase

    }

    override fun onCreate() {
        super.onCreate()

        appDatabase = Room.databaseBuilder(this, AppDatabase::class.java, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()

    }
}

