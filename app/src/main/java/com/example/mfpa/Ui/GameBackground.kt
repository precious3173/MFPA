package com.example.mfpa.Ui

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.mfpa.R

class GameBackground() {


        var x_: Int = 0
        var y_: Int = 0


        fun Gbackground(x:Int,y: Int, res: Resources): Bitmap{

            var backgrounds:Bitmap? = null
            backgrounds = BitmapFactory.decodeResource(
                res, R.drawable.naruto_background)

            backgrounds = Bitmap.createScaledBitmap(backgrounds!!, x, y, false)

          return backgrounds
        }



}