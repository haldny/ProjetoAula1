package com.haldny.projetoaula1

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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

        val button3 = findViewById<Button>(R.id.activity1_button3)
        button3.setOnClickListener {
            val uri = Uri.parse("https://www.google.com.br")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }

        val button4 = findViewById<Button>(R.id.activity1_button4)
        button4.setOnClickListener {

            val hasPermission = checkSelfPermission(Manifest.permission.CALL_PHONE)

            if (hasPermission == PackageManager.PERMISSION_GRANTED) {
                val uri = Uri.parse("tel:819885567877")
                val intent = Intent(Intent.ACTION_CALL, uri)
                startActivity(intent)
            } else {
                val permissions = arrayOf(Manifest.permission.CALL_PHONE)
                requestPermissions(permissions, 100)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 100
            && permissions[0] == Manifest.permission.CALL_PHONE
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            val uri = Uri.parse("tel:819885567877")
            val intent = Intent(Intent.ACTION_CALL, uri)

            if (checkSelfPermission(Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent)
            }
        } else {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Android Básico")

            builder.setCancelable(false)
            builder.setMessage("Hoje foi aula de Intents e Intents filters.")

            builder.setPositiveButton("FOI MASSA", { dialog, _ ->
                dialog.dismiss()
            })

            val dialog = builder.create()

            dialog.show()
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
