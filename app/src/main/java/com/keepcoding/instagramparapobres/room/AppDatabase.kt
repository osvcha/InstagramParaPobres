package com.keepcoding.instagramparapobres.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RoomImage::class], version = 1)

@TypeConverters(AppConverters::class, ArrayImagesConverter::class)

abstract class AppDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDAO
}