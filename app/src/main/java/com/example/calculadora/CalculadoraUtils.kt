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
                else -> throw IllegalArgumentException()
            }
            resultado.toString()
        } catch (e: Exception) {
            "Erro"
        }
    }
}
