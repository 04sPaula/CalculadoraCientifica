package com.example.calculadora
import kotlin.math.*

object CalculadoraUtils {
    fun calcularExpressao(input: String, operacao: (Double) -> Double): String {
        return try {
            val valor = input.toDouble()
            operacao(valor).toString()
        } catch (e: Exception) {
            "Erro"
        }
    }

    fun calcularFatorial(valor: Double): Double {
        if (valor < 0 || valor % 1 != 0.0) throw IllegalArgumentException("Fatorial inválido")
        var resultado = 1L
        for (i in 1..valor.toInt()) {
            resultado *= i
        }
        return resultado.toDouble()
    }

    fun calcularPorcentagem(valor: Double): Double {
        return valor / 100
    }

    fun calcularQuadrado(valor: Double): Double {
        return valor * valor
    }

    fun calcularSeno(valor: Double, emGraus: Boolean = true): Double {
        val rad = if (emGraus) Math.toRadians(valor) else valor
        return sin(rad)
    }

    fun calcularCosseno(valor: Double, emGraus: Boolean = true): Double {
        val rad = if (emGraus) Math.toRadians(valor) else valor
        return cos(rad)
    }

    fun calcularTangente(valor: Double, emGraus: Boolean = true): Double {
        val rad = if (emGraus) Math.toRadians(valor) else valor
        return tan(rad)
    }

    fun calcularInverso(valor: Double): Double {
        if (valor == 0.0) throw ArithmeticException("Divisão por zero")
        return 1 / valor
    }

    fun calcularRaizQuadrada(valor: Double): Double {
        if (valor < 0) throw IllegalArgumentException("Raiz de número negativo")
        return sqrt(valor)
    }

    fun calcularLogaritmoNatural(valor: Double): Double {
        if (valor <= 0) throw IllegalArgumentException("Log de número <= 0")
        return ln(valor)
    }

    fun calcularArcoSeno(valor: Double, emGraus: Boolean = true): Double {
        if (valor !in -1.0..1.0) throw IllegalArgumentException("asin fora do domínio")
        val resultado = asin(valor)
        return if (emGraus) Math.toDegrees(resultado) else resultado
    }

    fun calcularArcoCosseno(valor: Double, emGraus: Boolean = true): Double {
        if (valor !in -1.0..1.0) throw IllegalArgumentException("acos fora do domínio")
        val resultado = acos(valor)
        return if (emGraus) Math.toDegrees(resultado) else resultado
    }

    fun calcularArcoTangente(valor: Double, emGraus: Boolean = true): Double {
        val resultado = atan(valor)
        return if (emGraus) Math.toDegrees(resultado) else resultado
    }

    fun calcularOperacaoBinaria(
        temp1: Double,
        temp2: Double,
        operacao: Int
    ): String {
        return try {
            val resultado = when (operacao) {
                1 -> temp1 + temp2
                2 -> temp1 - temp2
                3 -> temp1 * temp2
                4 -> if (temp2 != 0.0) temp1 / temp2 else throw ArithmeticException()
                5 -> temp1.pow(temp2)
                else -> throw IllegalArgumentException()
            }
            resultado.toString()
        } catch (e: Exception) {
            "Erro"
        }
    }
}
