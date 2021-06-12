package com.keepcoding.instagramparapobres.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "images")
data class RoomImage(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "likes") val likes: Int,
    @ColumnInfo(name = "datetime") val datetime: Long,
    @ColumnInfo(name = "author") val author: String?,
    @ColumnInfo(name = "type") val imageType: ImageType,
    @ColumnInfo(name = "imagesCount") val imagesCount: Int,
    @TypeConverters(ArrayImagesConverter::class)
    val imagesUrls: ArrayList<String>?
) {
    enum class ImageType {
        HOT, TOP, MY_IMAGES
    }
}