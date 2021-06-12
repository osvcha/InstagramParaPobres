package com.keepcoding.instagramparapobres.room

import androidx.room.TypeConverter

class ArrayImagesConverter {

    @TypeConverter
    fun fromArray(list: ArrayList<String>): String = list.joinToString { it ->
        "\'${it}\'"
    }

    @TypeConverter
    fun toArray(json: String): ArrayList<String> {
        return ArrayList(json.split(","))
    }

}