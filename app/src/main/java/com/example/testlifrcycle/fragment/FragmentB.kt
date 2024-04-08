package com.example.testlifrcycle.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.testlifrcycle.R
import com.example.testlifrcycle.databinding.FragmentBBinding
import com.example.testlifrcycle.fragment.dialog.MyDialogFragment


class FragmentB : Fragment() {


    private lateinit var bindingFmB : FragmentBBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("hieulv","Attach FmB")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hieulv","Create FmB")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFmB = FragmentBBinding.inflate(inflater,container,false)
        Log.d("hieulv","Created View FmB")
        return bindingFmB.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("hieulv","Created FmB")
        val fragmentManager = requireActivity().supportFragmentManager
        bindingFmB.btnfm2.setOnClickListener(){
            fragmentManager.popBackStack()
        }

        bindingFmB.btnfm3.setOnClickListener(){
            val dialogFragment = MyDialogFragment()
            dialogFragment.show(requireActivity().supportFragmentManager, "dialog")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("hieulv","Start FmB")
    }

    override fun onResume() {
        super.onResume()
        Log.d("hieulv","Resume FmB")
    }

    override fun onPause() {
        super.onPause()
        Log.d("hieulv","Pause FmB")
    }

    override fun onStop() {
        super.onStop()
        Log.d("hieulv","Stop FmB")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("hieulv","Destroy View FmB")
    }

    override fun onDestroy() {
        Log.d("hieulv","Destroy FmB")
        super.onDestroy()

    }

    override fun onDetach() {
        Log.d("hieulv","Detach FmB")
        super.onDetach()
    }

    override fun getViewLifecycleOwner(): LifecycleOwner {
        return super.getViewLifecycleOwner()
    }

}