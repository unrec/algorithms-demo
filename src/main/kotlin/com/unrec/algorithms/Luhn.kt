package com.unrec.algorithms

fun validateLuhn(pan: String): Boolean {
    if (pan.length != 16) return false

    val (digits, others) = pan
        .filterNot(Char::isWhitespace)
        .partition(Char::isDigit)

    if (digits.length <= 1 || others.isNotEmpty()) {
        return false
    }

    val checksum = digits
        .map { Character.getNumericValue(it) }
        .mapIndexed { index, value ->
            if (index % 2 == 0 && value < 9) value * 2 % 9 else value
        }
        .sum()
    return checksum % 10 == 0
}