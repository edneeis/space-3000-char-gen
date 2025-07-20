package com.space.core

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GeneratorTests {

    @ParameterizedTest(name = "rollD{0} with bonus {1} and count {2} returns within range")
    @CsvSource(
        "4,0,1",
        "4,2,1",
        "4,-2,1",
        "6,3,2",
        "6,-1,4",
        "8,2,1",
        "10,0,3",
        "12,2,1",
        "20,5,1",
    )
    fun `rollDie with bonus and count returns within range`(sides: Int, bonus: Int, count: Int) {
        val generator = Generator()
        val result = generator.rollDie(sides, bonus, count)
        assertTrue(result >= ((1*count) + bonus), "Result should be at least 1 * count plus bonus")
        assertTrue(result <= ((sides*count) + bonus), "Result should be at most sides * count plus bonus")
    }
}