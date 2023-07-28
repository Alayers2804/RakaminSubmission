package com.bangkit.rakaminsubmission

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsBookmark::class], version = 1)
abstract class NewsDatabase : RoomDatabase()  {

    companion object {
        var INSTANCE : NewsDatabase? = null

        fun getDatabase(context: Context): NewsDatabase?{
            if (INSTANCE == null){
                synchronized(NewsDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "user database").build()
                }
            }
            return INSTANCE
        }
    }

    abstract fun newsDao(): NewsDao
}