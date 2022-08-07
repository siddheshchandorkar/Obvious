package com.siddhesh.commons

import java.text.SimpleDateFormat
import java.util.*

class AppUtils {

    companion object {

        fun getFormattedDate(date: String): String {
            var formattedDate = date
            try {
                val parseDate = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(date)
                formattedDate = SimpleDateFormat("dd MMMM, yyyy", Locale.US).format(parseDate!!)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                return formattedDate
            }
        }
    }


}