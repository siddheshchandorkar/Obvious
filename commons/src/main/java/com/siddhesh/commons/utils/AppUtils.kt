package com.siddhesh.commons.utils

import android.graphics.Color
import java.util.*

class AppUtils {

    companion object{
        fun getRandomColorCode():Int{
            val rnd = Random()
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        }
    }


}