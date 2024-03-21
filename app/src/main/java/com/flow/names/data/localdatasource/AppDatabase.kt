package com.flow.names.data.localdatasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.flow.names.data.names.Names
import com.flow.names.data.names.NamesDao

@Database(entities = [Names::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun namesDao(): NamesDao

    companion object {
        private lateinit var appDatabase: AppDatabase

        fun getDatabase(context: Context): AppDatabase {
            if (!Companion::appDatabase.isInitialized) {
                synchronized(AppDatabase::class.java) {
                    if (!Companion::appDatabase.isInitialized) {
                        appDatabase = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "names"
                        ).build()
                    }
                }
            }
            return appDatabase
        }
    }
}