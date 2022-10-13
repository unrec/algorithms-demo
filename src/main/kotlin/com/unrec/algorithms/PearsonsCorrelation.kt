package com.unrec.algorithms

import kotlin.math.round
import kotlin.math.sqrt

fun pearsonsCoefficient(x: IntArray, y: IntArray): Double {

    check(x.size == y.size) { "Arrays are not of the same length" }

    val size = x.size
    val xMean = x.mean()
    val yMean = y.mean()

    var deviationMultiplySum = 0.0
    var xDevSquareSum = 0.0
    var yDevSquareSum = 0.0

    for (i in 0 until size) {
        val xDev = x[i] - xMean
        val yDev = y[i] - yMean
        deviationMultiplySum += xDev * yDev
        xDevSquareSum += xDev * xDev
        yDevSquareSum += yDev * yDev
    }
    return (deviationMultiplySum / sqrt(xDevSquareSum * yDevSquareSum)).round(3)
}

private fun IntArray.mean() = this.sum() / this.size

private fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}

fun main() {
    val xArray = intArrayOf(6, 12, 13, 17, 22, 25, 27, 29, 30, 32)
    val yArray = intArrayOf(45, 47, 39, 58, 68, 76, 75, 74, 78, 81)
    val pearsonsCoefficient = pearsonsCoefficient(xArray, yArray)
    println("pearsonsCoefficient = $pearsonsCoefficient")
}
