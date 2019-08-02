package ca.campbell.optionsmenuprog

import android.media.Image
import android.os.Bundle
import android.app.Activity
import android.text.util.Linkify
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Activity2 : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // using the same layout as MainActivity with a few tweaks
        var tv = findViewById<View>(R.id.instrs) as TextView
        tv.setText(R.string.sound_credits)
        tv.autoLinkMask = Linkify.ALL
        tv.linksClickable = true

        tv = findViewById<View>(R.id.instrs2) as TextView
        tv.setText(R.string.instractivity2)

        val iv = findViewById<View>(R.id.imageButton) as ImageView
        iv.isClickable = false

        val bt = findViewById<View>(R.id.button) as Button
        bt.visibility = View.INVISIBLE
    }

    companion object {
        private val TAG = "OPTMENU2"
    }

}
