package com.example.homework2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var btn_0: Button
    private lateinit var btn_1: Button
    private lateinit var btn_2: Button
    private lateinit var btn_3: Button
    private lateinit var btn_4: Button
    private lateinit var btn_5: Button
    private lateinit var btn_6: Button
    private lateinit var btn_7: Button
    private lateinit var btn_8: Button
    private lateinit var btn_9: Button
    private lateinit var btn_d: Button
    private lateinit var btn_m: Button
    private lateinit var btn_min: Button
    private lateinit var btn_plus: Button
    private lateinit var btn_start: Button
    private lateinit var btn_end: Button
    private lateinit var btn_AC: Button
    private lateinit var btn_back: Button
    private lateinit var btn_equally: Button
    private lateinit var btn_point: Button
    private lateinit var result_text: TextView
    private lateinit var tabel: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0 = findViewById(R.id.btn_0)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_4 = findViewById(R.id.btn_4)
        btn_5 = findViewById(R.id.btn_5)
        btn_6 = findViewById(R.id.btn_6)
        btn_7 = findViewById(R.id.btn_7)
        btn_8 = findViewById(R.id.btn_8)
        btn_9 = findViewById(R.id.btn_9)
        btn_0 = findViewById(R.id.btn_0)
        btn_AC = findViewById(R.id.btn_AC)
        btn_back = findViewById(R.id.btn_back)
        btn_plus = findViewById(R.id.btn_plus)
        btn_point = findViewById(R.id.btn_point)
        btn_d = findViewById(R.id.btn_divide)
        btn_m = findViewById(R.id.btn_multiply)
        btn_min = findViewById(R.id.minus)
        btn_start = findViewById(R.id.btn_bracket_start)
        btn_end = findViewById(R.id.btn_bracket_end)
        btn_equally = findViewById(R.id.equally)
        result_text = findViewById(R.id.result)
        tabel = findViewById(R.id.tabel)


    }

    override fun onStart() {
        super.onStart()


        btn_0.setOnClickListener {
            setText("0")
        }
        btn_1.setOnClickListener {
            setText("1")
        }
        btn_2.setOnClickListener {
            setText("2")
        }
        btn_3.setOnClickListener {
            setText("3")
        }
        btn_3.setOnClickListener {
            setText("3")
        }
        btn_4.setOnClickListener {
            setText("4")
        }
        btn_5.setOnClickListener {
            setText("5")
        }
        btn_6.setOnClickListener {
            setText("6")
        }
        btn_7.setOnClickListener {
            setText("7")
        }
        btn_8.setOnClickListener {
            setText("8")
        }
        btn_9.setOnClickListener {
            setText("9")
        }
        btn_min.setOnClickListener {
            sign("-")
        }
        btn_plus.setOnClickListener {
            sign("+")
        }
        btn_point.setOnClickListener {
            setText(".")
        }
        btn_start.setOnClickListener {
            bracketstartCheck()
        }
        btn_end.setOnClickListener {
           setText(")")
            // bracketendCheck()
        }
        btn_m.setOnClickListener {
            sign("*")
        }
        btn_d.setOnClickListener {
            sign("/")
        }
        btn_AC.setOnClickListener {
            tabel.text = ""
            result_text.text = ""
        }
        btn_back.setOnClickListener {
            var str = tabel.text.toString()
            if (str.isNotEmpty()) {
                tabel.text = str.substring(0, str.length - 1)
            }

            result_text.text = ""
        }

        btn_equally.setOnClickListener {
            try {

                val builder = ExpressionBuilder(tabel.text.toString()).build()
                val result = builder.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble()) {
                    result_text.text = longRes.toString()
                } else {
                    result_text.text = result.toString()
                }

            } catch (e: Exception) {
               result_text.text = "Ошибка"
            }
        }
    }

    private fun setText(str: String) {
        if (result_text.text != "") {
            tabel.text = result_text.text
            result_text.text = ""
        }
        tabel.append(str)
    }

    private fun sign(sign: String) {
        var str = tabel.text.toString()
        if (str.isNotEmpty() && str.substring(str.length - 1, str.length) == "*" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "/" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "+" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "-"||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "("
        ) {
            tabel.text = str.substring(0, str.length - 1)
            setText(sign)
        } else {
            setText(sign)
        }
    }

    private fun bracketstartCheck() {
        var str = tabel.text.toString()
        if (str.isNotEmpty() && str.substring(str.length - 1, str.length) == "(") {
            tabel.text = str.substring(0, str.length - 1)
            setText("(")
        } else if (str.isNotEmpty() && str.substring(str.length - 1, str.length) == "*" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "/" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "+" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "-"||
                    str.isEmpty()
        ) {
            setText("(")
        } else {
            setText("*(")
        }
    }

    /*
    private fun bracketendCheck() {
        var str = tabel.text.toString()
        if (str.isNotEmpty() && str.substring(str.length - 1, str.length) == ")" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "*" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "/" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "+" ||
            str.isNotEmpty() && str.substring(str.length - 1, str.length) == "-") {
            tabel.text = str.substring(0, str.length - 1)
            setText(")")
        } else{
            setText(")")
        }
    }
     */
}


