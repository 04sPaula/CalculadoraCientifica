package com.example.calculadora
import kotlin.math.*
import net.objecthunter.exp4j.function.Function

object CalculadoraUtils {
    private const val PI = Math.PI
    private const val E = Math.E

fun avaliarExpressao(expressao: String, emGraus: Boolean = true): Double {
        val expr = expressao
            .replace("×", "*")
            .replace("÷", "/")
            .replace("π", Math.PI.toString())
            .replace("e", Math.E.toString())
            .replace("√", "sqrt")
            .replace("²", "^2")
            .replace("%", "*0.01")

        val expression = net.objecthunter.exp4j.ExpressionBuilder(expr)
            .functions(
                object : Function("fact", 1) {
                    override fun apply(vararg args: Double): Double {
                        val n = args[0]
                        if (n < 0 || n != n.toInt().toDouble()) throw IllegalArgumentException("Fatorial inválido")
                        return (1..n.toInt()).fold(1.0) { acc, i -> acc * i }
                    }
                },
                object : Function("sin", 1) {
                    override fun apply(vararg args: Double): Double {
                        val x = args[0]
                        return if (emGraus) Math.sin(Math.toRadians(x)) else Math.sin(x)
                    }
                },
                object : Function("cos", 1) {
                    override fun apply(vararg args: Double): Double {
                        val x = args[0]
                        return if (emGraus) Math.cos(Math.toRadians(x)) else Math.cos(x)
                    }
                },
                object : Function("tan", 1) {
                    override fun apply(vararg args: Double): Double {
                        val x = args[0]
                        return if (emGraus) Math.tan(Math.toRadians(x)) else Math.tan(x)
                    }
                },
                object : Function("asin", 1) {
                    override fun apply(vararg args: Double): Double {
                        val x = args[0]
                        return if (emGraus) Math.toDegrees(Math.asin(x)) else Math.asin(x)
                    }
                },
                object : Function("acos", 1) {
                    override fun apply(vararg args: Double): Double {
                        val x = args[0]
                        return if (emGraus) Math.toDegrees(Math.acos(x)) else Math.acos(x)
                    }
                },
                object : Function("atan", 1) {
                    override fun apply(vararg args: Double): Double {
                        val x = args[0]
                        return if (emGraus) Math.toDegrees(Math.atan(x)) else Math.atan(x)
                    }
                }
            )
            .build()

        return expression.evaluate()
    }

    private fun String.isNumber(): Boolean = matches("-?\\d+(\\.\\d+)?".toRegex())
    private fun String.isOperator(): Boolean = matches("[+\\-*/^]".toRegex())
    private fun String.isFunction(): Boolean = matches("(sin|cos|tan|asin|acos|atan|sqrt|log|ln|exp|abs|fact|percent)".toRegex())
    private fun String.isConstant(): Boolean = this == "PI" || this == "E"

    private fun precedencia(op: String): Int = when (op) {
        "+", "-" -> 1
        "*", "/" -> 2
        "^" -> 3
        "sin", "cos", "tan", "asin", "acos", "atan", "sqrt", "log", "ln", "exp", "abs", "fact" -> 4
        else -> 0
    }

    private fun avaliarOperadorBinario(a: Double, b: Double, op: String): Double = when (op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        "^" -> a.pow(b)
        else -> throw IllegalArgumentException("Operador desconhecido: $op")
    }

    private fun avaliarFuncao(funcao: String, x: Double, emGraus: Boolean): Double = when (funcao) {
        "sin" -> if (emGraus) sin(Math.toRadians(x)) else sin(x)
        "cos" -> if (emGraus) cos(Math.toRadians(x)) else cos(x)
        "tan" -> if (emGraus) tan(Math.toRadians(x)) else tan(x)
        "asin" -> if (emGraus) Math.toDegrees(asin(x)) else asin(x)
        "acos" -> if (emGraus) Math.toDegrees(acos(x)) else acos(x)
        "atan" -> if (emGraus) Math.toDegrees(atan(x)) else atan(x)
        "sqrt" -> sqrt(x)
        "log" -> log10(x)
        "ln" -> ln(x)
        "exp" -> exp(x)
        "abs" -> abs(x)
        "fact" -> calcularFatorial(x)
        "percent" -> x / 100
        else -> throw IllegalArgumentException("Função desconhecida: $funcao")
    }

    private fun avaliarConstante(constante: String): Double = when (constante) {
        "PI" -> PI
        "E" -> E
        else -> throw IllegalArgumentException("Constante desconhecida: $constante")
    }

    fun getOperador(op: Int): String {
        return when (op) {
            1 -> "+"
            2 -> "-"
            3 -> "×"
            4 -> "÷"
            5 -> "^"
            else -> "?"
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

}
