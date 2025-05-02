package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var MR = 0.0
        var temp1 = 0.0
        var temp2 = 0.0
        var resultado = 0.0
        var isResultado = false
        var operacao = 0

        val display = findViewById<TextView>(R.id.display)
        val btnCE = findViewById<TextView>(R.id.btnCE)
        val btnMMais = findViewById<Button>(R.id.btnMMais)
        val btnMMenos = findViewById<Button>(R.id.btnMMenos)
        val btnMRC = findViewById<Button>(R.id.btnMRC)
        val preview = findViewById<TextView>(R.id.preview)
        val btn1SobreX = findViewById<Button>(R.id.btn1SobreX)
        val btnAoQuadrado = findViewById<Button>(R.id.btnAoQuadrado)
        val btnSin = findViewById<Button>(R.id.btnSin)
        val btnCos = findViewById<Button>(R.id.btnCos)
        val btnTan = findViewById<Button>(R.id.btnTan)
        val btnASin = findViewById<Button>(R.id.btnASin)
        val btnRaizQuadrada = findViewById<Button>(R.id.btnRaizQuadrada)
        val btnACos = findViewById<Button>(R.id.btnACos)
        val btnATan = findViewById<Button>(R.id.btnATan)
        val btnDegRad = findViewById<Button>(R.id.btnDegRad)
        val btnPi = findViewById<Button>(R.id.btnPi)
        val btnAbreParenteses = findViewById<Button>(R.id.btnAbreParenteses)
        val btnFechaParenteses = findViewById<Button>(R.id.btnFechaParenteses)
        val btnPorcentagem = findViewById<Button>(R.id.btnPorcentagem)
        val btnFatorial = findViewById<Button>(R.id.btnFatorial)
        val btnIn = findViewById<Button>(R.id.btnIn)
        val btnXElevadoY = findViewById<Button>(R.id.btnXElevadoY)
        val btnMaisOuMenos = findViewById<Button>(R.id.btnMaisOuMenos)
        val btnEuler = findViewById<Button>(R.id.btnEuler)


        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)

        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnSubtrair = findViewById<Button>(R.id.btnSubtrair)
        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        val btnPonto = findViewById<Button>(R.id.btnPonto)
        val btnIgual = findViewById<Button>(R.id.btnIgual)

        btn0.setOnClickListener {
            if(!display.text.toString().equals("0"))
                display.setText(display.text.toString().plus("0"))
            isResultado = false
        }

        btn1.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("1")
            else
                display.setText(display.text.toString().plus("1"))
            isResultado = false
        }

        btn2.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("2")
            else
                display.setText(display.text.toString().plus("2"))
            isResultado = false
        }

        btn3.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("3")
            else
                display.setText(display.text.toString().plus("3"))
            isResultado = false
        }

        btn4.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("4")
            else
                display.setText(display.text.toString().plus("4"))
            isResultado = false
        }

        btn5.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("5")
            else
                display.setText(display.text.toString().plus("5"))
            isResultado = false
        }

        btn6.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("6")
            else
                display.setText(display.text.toString().plus("6"))
            isResultado = false
        }

        btn7.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("7")
            else
                display.setText(display.text.toString().plus("7"))
            isResultado = false
        }

        btn8.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("8")
            else
                display.setText(display.text.toString().plus("8"))

            isResultado = false
        }

        btn9.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.setText("9")
            else
                display.setText(display.text.toString().plus("9"))

            isResultado = false
        }

        btnCE.setOnClickListener {
            display.setText("0")
            MR = 0.0
            temp1 = 0.0
            temp2 = 0.0
            resultado = 0.0
            isResultado = false
            operacao = 0
        }

        btn1SobreX.setOnClickListener { }

        btnAoQuadrado.setOnClickListener { }

        btnSin.setOnClickListener { }

        btnCos.setOnClickListener { }

        btnTan.setOnClickListener { }

        btnASin.setOnClickListener { }

        btnRaizQuadrada.setOnClickListener { }

        btnACos.setOnClickListener { }

        btnATan.setOnClickListener { }

        btnDegRad.setOnClickListener { }

        btnPi.setOnClickListener { }

        btnAbreParenteses.setOnClickListener { }

        btnFechaParenteses.setOnClickListener { }

        btnPorcentagem.setOnClickListener { }

        btnFatorial.setOnClickListener { }

        btnIn.setOnClickListener { }

        btnXElevadoY.setOnClickListener { }

        btnMaisOuMenos.setOnClickListener { }

        btnEuler.setOnClickListener { }

        btnPonto.setOnClickListener {
            if (!display.text.toString().contains(".")) {
                display.setText(display.text.toString().plus("."))
            }
        }

        btnMRC.setOnClickListener {
            display.setText(MR.toString())
        }

        btnMMais.setOnClickListener {
            MR += display.text.toString().toDouble()
            display.setText("0")
            isResultado = true
        }

        btnMMenos.setOnClickListener {
            MR -= display.text.toString().toDouble()
            display.setText("0")
            isResultado = true
        }

        btnAdicionar.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 1
            display.setText("0")
        }

        btnSubtrair.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 2
            display.setText("0")
        }

        btnMultiplicar.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 3
            display.setText("0")
        }

        btnDividir.setOnClickListener {
            temp1 = display.text.toString().toDouble()
            operacao = 4
            display.setText("0")
        }

        btnIgual.setOnClickListener {
            temp2 = display.text.toString().toDouble()
            when(operacao) {
                1 -> resultado = temp1 + temp2
                2 -> resultado = temp1 - temp2
                3 -> resultado = temp1 * temp2
                4 -> if (temp2 != 0.0) {resultado = temp1 / temp2}
            }
            display.setText(resultado.toString())
            isResultado = true
        }

    }
}