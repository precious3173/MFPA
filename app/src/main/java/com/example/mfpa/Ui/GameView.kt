package com.example.mfpa.Ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceView
import android.view.View

class GameView


constructor(
    context: Context, x: Int, y: Int
) :  View(context), Runnable {

    private var thread: Thread? = null
    private var playing: Boolean? = null
    private var x: Int? = null
    private var y: Int? = null

    init {
        this.x =x
        this.y = y

    }




    val gameBackground = GameBackground()
    val gameBackground2 = GameBackground()

    val gameBackgrounds = gameBackground.Gbackground(x, y, resources)
    var gameBackgrounds2 = gameBackground2.Gbackground(x,y,resources)



    var gameBackgroundx = gameBackground.x_
    var gameBackgroundx2 = gameBackground2.x_


    override fun run() {
        while (playing!!){
            updateGame()
            sleepGame ()

        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

         canvas!!.drawBitmap(gameBackgrounds, gameBackgroundx.toFloat(), gameBackground.y_.toFloat(), null)
        canvas!!.drawBitmap(gameBackgrounds, gameBackgroundx2.toFloat(), gameBackground2.y_.toFloat(), null)
      //  holder.unlockCanvasAndPost(canvas)
    }



    private fun sleepGame() {

        try {
            Thread.sleep(17)
        }
        catch (e: InterruptedException){
            e.printStackTrace()
        }
    }

    private fun updateGame() {
        gameBackgroundx -= 10
        gameBackgroundx2 -= 10



        if (gameBackgroundx + gameBackgrounds.width < 0 ){
            gameBackgroundx = x!!
        }

        if (gameBackgroundx2 + gameBackgrounds2.width < 0 ){
            gameBackgroundx2 = x!!
        }
    }


    fun resume (){

     thread = object :Thread(this){

     }
        thread!!.start()
        playing = true
    }

    fun pause (){
       try {
           thread!!.join()
           playing = false
       } catch (e:InterruptedException){
               e.printStackTrace()
           }

    }
}