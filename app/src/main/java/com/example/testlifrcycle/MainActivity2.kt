package com.example.testlifrcycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testlifrcycle.databinding.ActivityMain2Binding
import com.example.testlifrcycle.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding
    val tag : String = "Activity"
    companion object {
        val tag : String = "Activity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.e("hieulv", "$tag 2 Create")

    }

    override fun onStart() {
        super.onStart()
        Log.e("hieulv", "$tag 2 Start")
    }

    override fun onResume() {
        super.onResume()
        Log.e("hieulv", "$tag 2 Resume")
        binding.btnLeftClick.setOnClickListener {
            finish()
        }
    }

    override fun onPause() {
        Log.e("hieulv", "$tag 2 Pause")
        super.onPause()
    }

    override fun onStop() {


        super.onStop()
        Log.e("hieulv", "$tag 2 Stop")
    }

    override fun onDestroy() {
        Log.e("hieulv", "$tag 2 Destroy")

        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }
}