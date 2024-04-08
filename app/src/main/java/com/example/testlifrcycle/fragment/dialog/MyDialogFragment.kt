package com.example.testlifrcycle.fragment.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onPause() {
        super.onPause()
        Log.d("---","Pause when showing up dialog Fm")
    }

    override fun onStop() {
        super.onStop()
        Log.d("---","Stop when showing up dialog Fm")
    }

}