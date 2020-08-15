package com.appat.myapplication

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_persistent.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // Do something for new state
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                val targetHeight = -1 * bottomSheet.height/2   // This height can be change as per the requirements
                ObjectAnimator.ofFloat(childLayout, "translationY", slideOffset * targetHeight).apply {
                    duration = 0
                    start()
                }
            }
        }
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
    }
}