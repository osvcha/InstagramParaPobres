package com.keepcoding.instagramparapobres.utils

import java.text.SimpleDateFormat
import java.util.*

private val simpleDateFormat = SimpleDateFormat.getDateTimeInstance()

fun getDateTimeFromTimeStamp(timestamp: Long): String? {
    return try {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val netDate = Date(timestamp * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        e.toString()
    }
}