package com.haldny.projetoaula1

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text2 = findViewById<TextView>(R.id.activity2_text2)
        text2.text = intent.getStringExtra("mytext")
    }

}
