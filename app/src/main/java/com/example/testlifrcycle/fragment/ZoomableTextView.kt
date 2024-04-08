package com.example.testlifrcycle.fragment

import android.content.Context
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import kotlin.math.max
import kotlin.math.min

class ZoomableTextView(context: Context) : AppCompatTextView(context) {
    private var scaleFactor = 1.0f
    private var scaleGestureDetector: ScaleGestureDetector

    init {
        scaleGestureDetector = ScaleGestureDetector(context, ScaleListener())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        return true
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scaleFactor *= detector.scaleFactor
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f))

            textSize *= scaleFactor // Cập nhật kích thước của văn bản

            return true
        }
    }
}