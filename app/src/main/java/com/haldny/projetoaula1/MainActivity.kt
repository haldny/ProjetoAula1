package com.haldny.projetoaula1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 102
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.activity1_button1)
        button1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("mytext", "Vitoria")

            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.activity1_button2)
        button2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)

            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val text1 = findViewById<TextView>(R.id.activity1_text1)

            text1.text = data?.getStringExtra("my_name")
        }
    }

}
