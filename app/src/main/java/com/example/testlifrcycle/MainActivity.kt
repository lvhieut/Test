package com.example.testlifrcycle

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.testlifrcycle.MainActivity2.Companion.tag
import com.example.testlifrcycle.adapter.PagerAdapter
import com.example.testlifrcycle.databinding.ActivityMainBinding
import com.example.testlifrcycle.fragment.FragmentA
import com.example.testlifrcycle.fragment.FragmentB
import com.example.testlifrcycle.fragment.FragmentC

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private lateinit var viewpager: ViewPager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

//        initView()

//        setupViewPager()
        Log.e("hieulv", "$tag 1 Create")
    }

    private fun setupViewPager() {
        val adapter = PagerAdapter(supportFragmentManager)

        val fragmentA: FragmentA = FragmentA()
        val fragmentB: FragmentB = FragmentB()
        val fragmentC: FragmentC = FragmentC()


        adapter.addFragment(fragmentA, "fragment A")
        adapter.addFragment(fragmentB, "fragment B")
        adapter.addFragment(fragmentC, "fragment B")

        viewpager.adapter = adapter
    }

    private fun initView() {
//            viewpager = binding.viewPager.findViewById(R.id.viewPager)
    }

    override fun onStart() {
        super.onStart()
        Log.e("hieulv", "$tag 1 Start")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        Log.e("hieulv", "$tag 1 Resume")
        /*binding.btnRighClick.setOnClickListener {
//            val moveToScr2 = Intent(this@MainActivity, MainActivity2::class.java)
//            startActivity(moveToScr2)

            showAlertDialog(this)
        }*/

        /*binding.tv1.setOnClickListener(){ v ->
//            showPopupMenu(v)
        }*/
    }

    private fun showPopupMenu(v: View) {
        val popupMenu = PopupMenu(applicationContext, v)
        popupMenu.inflate(R.menu.item_menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_finish -> {
                    true
                }
                R.id.action_delete -> {
                    // Xử lý khi mục "Delete" được chọn
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showAlertDialog(context: Context) {
        val alertDialogBuilder = AlertDialog.Builder(context)

        alertDialogBuilder.setTitle("Tiêu đề")

        alertDialogBuilder.setMessage("Nội dung của AlertDialog")

        alertDialogBuilder.setCancelable(true)
        alertDialogBuilder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        alertDialogBuilder.setPositiveButton("OK") { _, _ ->
        }
        // Tạo đối tượng AlertDialog từ AlertDialog.Builder
        val alertDialog: AlertDialog = alertDialogBuilder.create()


        // Hiển thị AlertDialog
        alertDialog.show()

        Log.d("---","alert dialog")
    }

    override fun onPause() {
        Log.e("hieulv", "$tag 1 Pause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("hieulv", "$tag 1 Stop")

        super.onStop()
    }

    override fun onDestroy() {
        Log.e("hieulv", "$tag 1 Destroy")

        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("hieulv", "$tag 1 Restart")

    }
}