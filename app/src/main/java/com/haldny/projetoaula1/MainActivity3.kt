package com.haldny.projetoaula1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val editText3 = findViewById<EditText>(R.id.activity3_edittext1)
        val button3 = findViewById<Button>(R.id.activity3_button1)

        button3.setOnClickListener {
            val text = editText3.text.toString()
            val intent = Intent()
            intent.putExtra("my_name", text)

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }

}
