package com.unrec.algorithms

fun String.lastChar(): Char = get(length - 1)

fun String.incrementLastDigit(): String =
    this.substring(0, this.length - 1) + (Character.getNumericValue(this.lastChar()) + 1) % 10
