package com.example.vamos_rachar_494828

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val qtd = findViewById<EditText>(R.id.qtd)
        val valor = findViewById<EditText>(R.id.valor)
        val result = findViewById<EditText>(R.id.result)
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        qtd.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val calculo = df.format((valor.text.toString().toFloat()/qtd.text.toString().toFloat()).toBigDecimal())
                result.setText(calculo.toString())
                result.setFocusable(false)
                result.setFocusableInTouchMode(false)
                result.setClickable(false)
            }
        }
        valor.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val calculo = df.format((valor.text.toString().toFloat()/qtd.text.toString().toFloat()).toBigDecimal())
                result.setText(calculo.toString())
            }
        }
        val button = findViewById<ImageButton>(R.id.share)
        button.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                val shareResult = result.text.toString()
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Fica $shareResult reais pra cada!")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
        }

    }
