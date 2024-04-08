package com.example.testlifrcycle.fragment

import android.content.Context
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import kotlin.math.max
import kotlin.math.min

class ZoomableTextView(context: Context) : AppCompatTextView(context) {
    companion object {
        private const val MIN_SCALE_FACTOR = 0.1f
        private const val MAX_SCALE_FACTOR = 5.0f
    }

    private var scaleFactor = 1.0f

    private var lastTouchX = 0f
    private var lastTouchY = 0f

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                lastTouchX = event.x
                lastTouchY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                val deltaX: Float = event.x - lastTouchX
                val deltaY: Float = event.y - lastTouchY
                lastTouchX = event.x
                lastTouchY = event.y

                val newXScale = scaleX + deltaX / 100
                val newYScale = scaleY + deltaY / 100

                val newScaleX = max(MIN_SCALE_FACTOR, min(newXScale, MAX_SCALE_FACTOR))
                val newScaleY = max(MIN_SCALE_FACTOR, min(newYScale, MAX_SCALE_FACTOR))

                scaleX = newScaleX
                scaleY = newScaleY
            }
        }
        return true
    }
}