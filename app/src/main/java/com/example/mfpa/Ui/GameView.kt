package com.example.mfpa.Ui

import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceView
import android.view.View

class GameView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : SurfaceView(context, attrs), Runnable {

    private var thread: Thread? = null
    private var playing: Boolean? = null

    override fun run() {
        while (playing!!){
            updateGame()
            drawGame()
            sleepGame ()

        }
    }

    private fun drawGame() {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }


    fun resume (){

     thread = Thread(this)
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