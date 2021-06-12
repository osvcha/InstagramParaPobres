package com.keepcoding.instagramparapobres.gallery

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList


data class Gallery(val images: List<Image>)
data class Image(
    val id: String,
    val title: String?,
    val url: String?,
    val likes: Int,
    val datetime: Long,
    val author: String?,
    val imagesCount: Int,
    val imagesUrls: ArrayList<String>?
) : Parcelable {
    val authorAvatar: String by lazy {
        "https://imgur.com/user/${author}/avatar"
    }

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readInt(),
        parcel.createStringArrayList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeInt(likes)
        parcel.writeLong(datetime)
        parcel.writeString(author)
        parcel.writeInt(imagesCount)
        parcel.writeStringList(imagesUrls)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(source: Parcel): Image {
            return Image(source)
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }
}
