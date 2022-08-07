package com.siddhesh.commons.utils

import android.graphics.Color
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class AppUtils {

    companion object{
        fun getRandomColorCode():Int{
            val rnd = Random()
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        }

        fun getFormattedDate(date:String):String{
            var formattedDate= ""

            try {
                val parseDate = SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(date)
                formattedDate=SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH).format(parseDate!!)
            }catch (e: Exception){
                return date
            }
            finally {
                return formattedDate
            }
        }
    }


}