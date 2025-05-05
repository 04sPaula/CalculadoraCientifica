package com.example.calculadora
import java.util.EmptyStackException
import kotlin.math.*
import java.util.Stack

object CalculadoraUtils {
    private const val PI = Math.PI
    private const val E = Math.E

    fun avaliarExpressao(expressao: String, emGraus: Boolean = true): Double {
        var expr = expressao
            .replace(" ", "")
            .replace("π", "PI")
            .replace("e", "E")
            .replace("²", "^2")
            .replace("√", "sqrt")
            .replace(Regex("(\\d+(\\.\\d+)?)%")) { "percent(${it.groupValues[1]})" }
            .replace(Regex("(\\d+)!")) { "fact(${it.groupValues[1]})" }
            .replace(Regex("(\\d+)%")) { "(${"%.2f".format(it.groupValues[1].toDouble() / 100)})" }

        return avaliarNotacaoPolonesaInversa(
            converterParaNotacaoPolonesaInversa(expr),
            emGraus
        )
    }

    private fun converterParaNotacaoPolonesaInversa(expressao: String): List<String> {
        val output = mutableListOf<String>()
        val operadores = Stack<String>()
        var i = 0

        while (i < expressao.length) {
            when (val c = expressao[i]) {
                in '0'..'9', '.' -> {
                    val num = StringBuilder()
                    while (i < expressao.length &&
                        (expressao[i].isDigit() || expressao[i] == '.')) {
                        num.append(expressao[i++])
                    }
                    output.add(num.toString())
                }
                '(', '[' -> {
                    operadores.push(c.toString())
                    i++
                }
                ')', ']' -> {
                    while (operadores.isNotEmpty() && operadores.peek() != "(" && operadores.peek() != "[") {
                        output.add(operadores.pop())
                    }
                    operadores.pop()
                    i++
                }
                '+', '-', '*', '/', '^' -> {
                    while (operadores.isNotEmpty() &&
                        precedencia(operadores.peek()) >= precedencia(c.toString())) {
                        output.add(operadores.pop())
                    }
                    operadores.push(c.toString())
                    i++
                }
                else -> {
                    if (c.isLetter()) {
                        val token = StringBuilder()
                        while (i < expressao.length && expressao[i].isLetter()) {
                            token.append(expressao[i++])
                        }
                        when (token.toString()) {
                            "PI", "E" -> output.add(token.toString())
                            else -> operadores.push(token.toString())
                        }
                    } else {
                        i++
                    }
                }
            }
        }

        while (operadores.isNotEmpty()) {
            output.add(operadores.pop())
        }

        return output
    }

    private fun avaliarNotacaoPolonesaInversa(tokens: List<String>, emGraus: Boolean): Double {
        val pilha = Stack<Double>()
        if (tokens.isEmpty()) throw IllegalArgumentException("Expressão vazia")
        if (tokens.size == 1 && !tokens[0].isNumber() && !tokens[0].isConstant())
            throw IllegalArgumentException("Expressão inválida: ${tokens[0]}")

        for (token in tokens) {
            when {
                token.isNumber() -> pilha.push(token.toDouble())
                token.isOperator() -> {
                    val b = pilha.pop()
                    val a = try { pilha.pop() } catch (e: EmptyStackException) {
                        throw IllegalStateException("Operador '$token' com operandos insuficientes")
                    }
                    pilha.push(avaliarOperadorBinario(a, b, token))
                }
                token.isFunction() -> {
                    val x = pilha.pop()
                    pilha.push(avaliarFuncao(token, x, emGraus))
                }
                token.isConstant() -> {
                    pilha.push(avaliarConstante(token))
                }
            }
        }

        if (pilha.isEmpty()) throw IllegalStateException("Erro de sintaxe: operandos insuficientes")
        return pilha.pop()
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
