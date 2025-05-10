package com.example.calculadora
import net.objecthunter.exp4j.function.Function

object CalculadoraUtils {

fun avaliarExpressao(expressao: String, emGraus: Boolean = true): Double {
    val expr = expressao
        .replace("×", "*")
        .replace("÷", "/")
        .replace("π", Math.PI.toString())
        .replace("e", Math.E.toString())
        .replace("√", "sqrt")
        .replace("²", "^2")

    val exprComPorcentagem = aplicarPorcentagem(expr)

    val expression = net.objecthunter.exp4j.ExpressionBuilder(exprComPorcentagem)
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
                    return if (emGraus) Math.sin(degRad(x, false)) else Math.sin(x)
                }
            },
            object : Function("cos", 1) {
                override fun apply(vararg args: Double): Double {
                    val x = args[0]
                    return if (emGraus) Math.cos(degRad(x, false)) else Math.cos(x)
                }
            },
            object : Function("tan", 1) {
                override fun apply(vararg args: Double): Double {
                    val x = args[0]
                    return if (emGraus) Math.tan(degRad(x, false)) else Math.tan(x)
                }
            },
            object : Function("asin", 1) {
                override fun apply(vararg args: Double): Double {
                    val x = args[0]
                    if (x < -1.0 || x > 1.0) throw IllegalArgumentException("asin indefinido" +
                            "para x ∉ [-1, 1]")
                    return if (emGraus) Math.toDegrees(Math.asin(x)) else Math.asin(x)
                }
            },
            object : Function("acos", 1) {
                override fun apply(vararg args: Double): Double {
                    val x = args[0]
                    if (x < -1.0 || x > 1.0) throw IllegalArgumentException("acos indefinido" +
                            "para x ∉ [-1, 1]")
                    return if (emGraus) Math.toDegrees(Math.acos(x)) else Math.acos(x)
                }
            },
            object : Function("atan", 1) {
                override fun apply(vararg args: Double): Double {
                    val x = args[0]
                    return if (emGraus) Math.toDegrees(Math.atan(x)) else Math.atan(x)
                }
            },
            object : Function("ln", 1) {
                override fun apply(vararg args: Double): Double {
                    val x = args[0]
                    if (x <= 0.0) throw IllegalArgumentException("ln indefinido para x ≤ 0")
                    return Math.log(x)
                }
            }
        )
        .build()

    return expression.evaluate()
    }

    private fun aplicarPorcentagem(expr: String): String {
        val regex = Regex("""([\dπe\(\)]+(?:\.\d+)?(?:[\dπe\+\-\*/\(\)\.]*?)?)\s*([+\-*/])\s*(\d+(?:\.\d+)?)%""")
        return regex.replace(expr) { match ->
            val a = match.groupValues[1]
            val op = match.groupValues[2]
            val b = match.groupValues[3]
            when (op) {
                "+", "-" -> "$a$op($a*$b/100)"
                "*", "/" -> "$a$op($b/100)"
                else -> match.value
            }
        }.replace("%", "/100")
    }

    fun degRad(valor: Double, emGraus: Boolean): Double {
        return if (emGraus) {
            Math.toDegrees(valor)
        } else {
            Math.toRadians(valor)
        }
    }

}
