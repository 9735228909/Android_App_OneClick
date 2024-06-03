package com.app.androidapponeclick

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1: EditText = findViewById(R.id.editText1)
        val editText2: EditText = findViewById(R.id.editText2)
        val editText3: EditText = findViewById(R.id.editText3)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val list1 = editText1.text.toString().split(",").map { it.trim().toInt() }
            val list2 = editText2.text.toString().split(",").map { it.trim().toInt() }
            val list3 = editText3.text.toString().split(",").map { it.trim().toInt() }

            val intersection = list1.intersect(list2).intersect(list3)
            val union = list1.union(list2).union(list3)
            val highestNumber = union.maxOrNull()

            resultTextView.text = """
                Intersection: ${intersection.joinToString(", ")}
                Union: ${union.joinToString(", ")}
                Highest Number: $highestNumber
            """.trimIndent()
        }
    }
}
