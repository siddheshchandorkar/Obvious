package com.siddhesh.commons

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
            var formattedDate= date
            try {
                val parseDate = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(date)
                formattedDate=SimpleDateFormat("dd MMMM, yyyy", Locale.US).format(parseDate!!)
            }catch (e: Exception){
                e.printStackTrace()
            }
            finally {
                return formattedDate
            }
        }
    }


}