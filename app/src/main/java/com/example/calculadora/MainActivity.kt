package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.CalculadoraUtils


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
        var emGraus = true

        val preview = findViewById<TextView>(R.id.preview)
        val display = findViewById<TextView>(R.id.display)
        val btnCE = findViewById<TextView>(R.id.btnCE)
        val btnMMais = findViewById<Button>(R.id.btnMMais)
        val btnMMenos = findViewById<Button>(R.id.btnMMenos)
        val btnMRC = findViewById<Button>(R.id.btnMRC)
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
        val btnLn = findViewById<Button>(R.id.btnLn)
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

        fun atualizarPreview() {
            try {
                val expressao = display.text.toString()
                if (expressao.isNotEmpty() && expressao != "0") {
                    val resultado = CalculadoraUtils.avaliarExpressao(expressao, emGraus)
                    preview.text = "= $resultado"
                } else {
                    preview.text = ""
                }
            } catch (e: Exception) {
                preview.text = ""
            }
        }

        fun adicionarOperador(operador: String) {
            val textoAtual = display.text.toString()
            if (textoAtual.isNotEmpty() && textoAtual.last() !in "+-×÷(") {
                display.text = "$textoAtual$operador"
            } else if (operador == "-" && (textoAtual.isEmpty() || textoAtual.last() == '(')) {
                display.text = "$textoAtual$operador"
            }
            atualizarPreview()
        }

        btn0.setOnClickListener {
            if(!display.text.toString().equals("0"))
                display.text = display.text.toString().plus("0")
            isResultado = false
            atualizarPreview()
        }

        btn1.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "1"
            else
                display.text = display.text.toString().plus("1")
            isResultado = false
            atualizarPreview()
        }

        btn2.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "2"
            else
                display.text = display.text.toString().plus("2")
            isResultado = false
            atualizarPreview()
        }

        btn3.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "3"
            else
                display.text = display.text.toString().plus("3")
            isResultado = false
            atualizarPreview()
        }

        btn4.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "4"
            else
                display.text = display.text.toString().plus("4")
            isResultado = false
            atualizarPreview()
        }

        btn5.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "5"
            else
                display.text = display.text.toString().plus("5")
            isResultado = false
            atualizarPreview()
        }

        btn6.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "6"
            else
                display.text = display.text.toString().plus("6")
            isResultado = false
            atualizarPreview()
        }

        btn7.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "7"
            else
                display.text = display.text.toString().plus("7")
            isResultado = false
            atualizarPreview()
        }

        btn8.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "8"
            else
                display.text = display.text.toString().plus("8")

            isResultado = false
            atualizarPreview()
        }

        btn9.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado)
                display.text = "9"
            else
                display.text = display.text.toString().plus("9")

            isResultado = false
            atualizarPreview()
        }

        btnCE.setOnClickListener {
            display.text = "0"
            preview.text = "0"
            MR = 0.0
            temp1 = 0.0
            temp2 = 0.0
            resultado = 0.0
            isResultado = false
            operacao = 0
        }

        btn1SobreX.setOnClickListener {
            display.text = "1/(${display.text})"
            atualizarPreview()
        }

        btnAoQuadrado.setOnClickListener {
            display.text = "(${display.text})²"
            atualizarPreview()
        }

        btnSin.setOnClickListener {
            display.text = "sin(${display.text})"
            atualizarPreview()
        }

        btnCos.setOnClickListener {
            display.text = "cos(${display.text})"
            atualizarPreview()
        }

        btnTan.setOnClickListener {
            display.text = "tan(${display.text})"
            atualizarPreview()
        }

        btnRaizQuadrada.setOnClickListener {
            display.text = "√(${display.text})"
            atualizarPreview()
        }

        btnASin.setOnClickListener {
            display.text = "asin(${display.text})"
            atualizarPreview()
        }

        btnACos.setOnClickListener {
            display.text = "acos(${display.text})"
            atualizarPreview()
        }

        btnATan.setOnClickListener {
            display.text = "atan(${display.text})"
            atualizarPreview()
        }

        btnDegRad.setOnClickListener {
            emGraus = !emGraus
            btnDegRad.text = if (emGraus) "Graus" else "Radianos"
        }

        btnPi.setOnClickListener {
            if(display.text.toString().equals("0") || isResultado) {
                display.text = "π"
            } else {
                display.text = display.text.toString().plus("π")
            }
            isResultado = false
        }

        btnAbreParenteses.setOnClickListener {
            if(!display.text.toString().equals("0")) {
                display.text = display.text.toString().plus("(")
            } else {
                display.text = "("
            }
        }

        btnFechaParenteses.setOnClickListener {
            if(!display.text.toString().equals("0")) {
                display.text = display.text.toString().plus(")")
            } else {
                display.text = ")"
            }
        }

        btnPorcentagem.setOnClickListener {
            display.text = "(${display.text})%"
            atualizarPreview()
        }

        btnFatorial.setOnClickListener {
            if (!display.text.toString().contains("!")) {
                display.text = "fact(${display.text})"
                atualizarPreview()
            }
        }

        btnLn.setOnClickListener {
            display.text = "ln(${display.text})"
            val resultado = CalculadoraUtils.avaliarExpressao(display.text.toString(), emGraus)
            preview.text = resultado.toString()
        }

        btnXElevadoY.setOnClickListener {
            val valorStr = display.text.toString()
            val valor = valorStr.toDoubleOrNull() ?: return@setOnClickListener
            temp1 = valor
            operacao = 5
            preview.text = "$valor ^"
            display.text = "0"
        }

        btnMaisOuMenos.setOnClickListener {
            val valor = display.text.toString().toDoubleOrNull()
            if (valor != null) {
                val invertido = -valor
                display.text = invertido.toString()
                isResultado = false
            }
        }

        btnEuler.setOnClickListener {
            val valorE = Math.E.toString()
            if (display.text.toString() == "0" || isResultado) {
                display.text = valorE
            } else {
                display.text = display.text.toString().plus(valorE)
            }
            isResultado = false
        }

        btnPonto.setOnClickListener {
            if (!display.text.toString().contains(".")) {
                display.text = display.text.toString().plus(".")
            }
        }

        btnMRC.setOnClickListener {
            display.text = MR.toString()
        }

        btnMMais.setOnClickListener {
            MR += display.text.toString().toDouble()
            display.text = "0"
            isResultado = true
        }

        btnMMenos.setOnClickListener {
            MR -= display.text.toString().toDouble()
            display.text = "0"
            isResultado = true
        }

        btnAdicionar.setOnClickListener {
            adicionarOperador("+")
        }

        btnSubtrair.setOnClickListener {
            adicionarOperador("-")
        }

        btnMultiplicar.setOnClickListener {
            adicionarOperador("×")
        }

        btnDividir.setOnClickListener {
            adicionarOperador("÷")
        }

        btnIgual.setOnClickListener {
            try {
                val expressao = display.text.toString()
                if (expressao.isNotEmpty() && expressao != "0") {
                    val resultado = CalculadoraUtils.avaliarExpressao(expressao, emGraus)
                    preview.text = "$expressao ="
                    display.text = resultado.toString()
                    isResultado = true
                }
            } catch (e: Exception) {
                display.text = "Erro"
                preview.text = ""
            }
        }
    }
}