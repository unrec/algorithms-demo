package com.unrec.algorithms

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LuhnKtTest {

    @ParameterizedTest(name = "pan = {0}")
    @MethodSource("validPans")
    fun `Check valid cards using Luhn algorithm`(pan: String) {
        assertTrue(validateLuhn(pan))
    }

    @ParameterizedTest(name = "pan = {0}")
    @MethodSource("invalidPans")
    fun `Check invalid cards using Luhn algorithm`(pan: String) {
        assertFalse(validateLuhn(pan))
    }

    companion object {
        @JvmStatic
        fun validPans(): Stream<Arguments> = validPansArray().map { Arguments.of(it) }.stream()

        @JvmStatic
        fun invalidPans(): Stream<Arguments> =
            validPansArray().map { Arguments.of(it.incrementLastDigit()) }.stream()

        private fun validPansArray() = arrayOf(
            "4012888888881881", "4111111111111111", "5555555555554444", "5105105105105100",
            "4035501000000008", "4001020000000009", "2222400070000005", "5100060000000002",
            "4704116594362274", "4539038310079936", "5509420803262109", "2720993927828294"
        )
    }
}