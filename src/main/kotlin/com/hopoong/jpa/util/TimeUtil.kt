package com.hopoong.jpa.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TimeUtil {

    fun getFormattedTimestamp(): String {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        return now.format(formatter)
    }

}