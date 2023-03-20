package com.example.hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get

class MainActivity2 : AppCompatActivity() {

    lateinit var optionSize : Spinner
    lateinit var optionColor : Spinner
    var size = ""
    var color = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        optionSize = findViewById(R.id.spinnerSize) as Spinner
        optionColor = findViewById(R.id.spinnerColor) as Spinner
        //val optionsize = arrayOf("XS","S","M","L","XL","2XL","3XL")
        //val optioncolor = arrayOf("黑色","白色","藍色","土黃色","灰色","軍綠色","酒紅色")
        val optionsize = resources.getStringArray(R.array.size)
        val optioncolor = resources.getStringArray(R.array.color)
        optionSize.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,optionsize)
        optionColor.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,optioncolor)
        optionSize.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                size = optionsize.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                size = "null"
            }

        }
        optionColor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                color = optioncolor.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                color = "null"
            }

        }
        intent?.extras?.let{
            val name = it.getString("keyName")
            val sex = it.getString("keySex")
            val button1 = findViewById<Button>(R.id.snedBack)
            button1.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("keySex",sex)
                bundle.putString("keyName",name)
                bundle.putString("keySize",size)
                bundle.putString("keyColor",color)
                val intent = Intent().putExtras(bundle)
                setResult(Activity.RESULT_OK, intent.putExtras(bundle))
                finish()
            }
        }
    }
}