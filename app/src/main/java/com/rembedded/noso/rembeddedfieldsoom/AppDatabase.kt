package com.rembedded.noso.rembeddedfieldsoom

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database(entities = arrayOf(
        DocumentLocal::class), version = 1)
@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "app_db"
    }

    abstract fun getDocumentsDao(): DocumentsDao
}