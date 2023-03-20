package com.example.hw1

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.snedNext)
        val nameEditText = findViewById<EditText>(R.id.clientName)
        val genderGroup = findViewById<RadioGroup>(R.id.genderSelection)
        button.setOnClickListener{
            val bundle = Bundle()
            val sex = genderGroup.findViewById<RadioButton>(genderGroup.checkedRadioButtonId).text.toString()
            val intent = Intent(this,MainActivity2::class.java)
            val name = nameEditText.text.toString()
            val size = "111"
            val color = "222"
            bundle.putString("keyName",name)
            bundle.putString("keySex",sex)
            bundle.putString("keySize",size)
            bundle.putString("keyColor",color)
            intent.putExtras(bundle)
            startActivityForResult(intent,1)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {
            if(requestCode == 1 && resultCode == Activity.RESULT_OK){
                findViewById<TextView>(R.id.textViewAll).text =
                    "Name: ${it.getString("keyName")}\n" +
                    "Gender: ${it.getString("keySex")}\n"+
                    "Size: ${it.getString("keySize")}\n" +
                    "Color: ${it.getString("keyColor")}"
            }
        }
    }
}