package com.example.testlifrcycle.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testlifrcycle.databinding.FragmentABinding


class FragmentA : Fragment() {
    private lateinit var bindingFmA : FragmentABinding
    private var lastTouchX = 0f
    private  var lastTouchY = 0f
    private val textViewArray = ArrayList<TextView>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("hieulv","Attach FmA")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hieulv","Create FmA")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFmA = FragmentABinding.inflate(inflater,container,false)
        Log.d("hieulv","Created View FmA")
        return bindingFmA.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("hieulv","Created FmA")


        bindingFmA.btnfm1.setOnClickListener(){
            createNewTextView()
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun createNewTextView() {
        val textView = ZoomableTextView(requireContext())
        textView.text = "New TextView"
        textViewArray.add(textView)
        textView.id = View.generateViewId() // Tạo ID mới cho TextView


        textView.setOnTouchListener { v, event ->
            val x = event.rawX
            val y = event.rawY

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Toast.makeText(context,"ádasdas",Toast.LENGTH_SHORT).show()
                    lastTouchX = x
                    lastTouchY = y
                }

                MotionEvent.ACTION_MOVE -> {
                    val deltaX: Float = x - lastTouchX
                    val deltaY: Float = y - lastTouchY
                    val translationX = v.translationX + deltaX
                    val translationY = v.translationY + deltaY
                    v.translationX = translationX
                    v.translationY = translationY
                    lastTouchX = x
                    lastTouchY = y
                }
                MotionEvent.ACTION_UP -> {

                }
            }
            true
        }


        textView.setOnClickListener(object : View.OnClickListener{ override fun onClick(v: View) {
        }
        })

        textView.setOnDragListener { view, dragEvent ->
            when (dragEvent.action) {
                DragEvent.ACTION_DROP -> {
                    true
                }
                else -> false
            }
        }

        bindingFmA.linear.addView(textView)

        val textViewId = textView.id

        zoomTextView(textViewId)
        Log.d("FragmentA", "TextView ID: $textViewId")
    }

    private fun zoomTextView(textViewId: Int) {
        // Tìm TextView trong danh sách textViewArray dựa trên ID
        val textViewToZoom = textViewArray.find { it.id == textViewId }

        // Kiểm tra xem TextView có tồn tại không
        textViewToZoom?.let {
            // Lấy các thông số cũ
            val layoutParams = it.layoutParams
            val originalWidth = layoutParams.width
            val originalHeight = layoutParams.height

            // Thay đổi kích thước của TextView
            layoutParams.width = (originalWidth * 10).toInt() // Scale theo chiều ngang
            layoutParams.height = (originalHeight * 10).toInt() // Scale theo chiều dọc
            it.layoutParams = layoutParams
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("hieulv","Start FmA")
    }

    override fun onResume() {
        super.onResume()
        Log.d("hieulv","Resume FmA")
    }

    override fun onPause() {
        super.onPause()
        Log.d("hieulv","Pause FmA")
    }

    override fun onStop() {
        super.onStop()
        Log.d("hieulv","Stop FmA")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("hieulv","Destroy View FmA")
    }

    override fun onDestroy() {
        Log.d("hieulv","Destroy FmA")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("hieulv","Detach FmA")
        super.onDetach()
    }


}