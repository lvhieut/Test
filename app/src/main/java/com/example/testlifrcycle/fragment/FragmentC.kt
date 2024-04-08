package com.example.testlifrcycle.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.util.Log
import android.view.ViewGroup
import com.example.testlifrcycle.R

class FragmentC : Fragment() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("---","Create")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("---","create View")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("---","view created")

    }




    override fun onStart() {
        super.onStart()
        Log.d("---","start")
    }


    override fun onResume() {
        super.onResume()
        Log.d("---","resume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("---","pause")

    }

    override fun onStop() {
        Log.d("---","stop")

        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("---","destroy view")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("---","destroy")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("---","detach")

    }

}