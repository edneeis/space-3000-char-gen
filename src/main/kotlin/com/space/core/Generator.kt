package com.space.core

import kotlin.random.Random

class Generator {

    fun rollDie(sides: Int): Int {
        val result =  Random.nextInt(1, sides)
        println("Rolling D$sides...$result")
        return result
    }

    fun rollDie(sides: Int, bonus: Int, count: Int): Int {
        var result: Int = bonus
        for (i in 1..count) {
            result += rollDie(sides)
            println("Rolling D$sides + $bonus...$result, count $count")
        }
        return result
    }

    fun RollDice(dieCount: Int, dieSides: Int): Pair<Int, IntArray> {
        if (dieCount <= 0 || dieSides <= 0) {
            throw IllegalArgumentException("Die count and sides must be greater than zero.")
        }

        var total = 0
        val rolls = IntArray(dieCount) {
            val roll = (1..dieSides).random()
            total += roll
            roll
        }
        println("Rolled ${dieCount}d${dieSides} for $total (${rolls.joinToString("+")})")
        return Pair(total, rolls)
    }

    fun RollAbilityScore(): Int {

        // Roll 6d4, drop the lowest die, and sum the rest
        val result = RollDice(6, 4)
        val rolls = result.second
        val lowest = rolls.minOrNull() ?: 0
        val total = rolls.sum() - lowest
        println("Lowest roll dropped: $lowest, total is $total")
        return total
    }

    fun RollAbilityScores(): IntArray {

        // Roll 7 ability scores, drop the lowest, and return the rest
        var scores = mutableListOf<Int>()
        scores.add(RollAbilityScore())
        scores.add(RollAbilityScore())
        scores.add(RollAbilityScore())
        scores.add(RollAbilityScore())
        scores.add(RollAbilityScore())
        scores.add(RollAbilityScore())
        scores.add(RollAbilityScore())
        scores.sortDescending()
        val lowest = scores.last()
        scores.remove(lowest)
        println("Lowest score dropped: $lowest, remaining scores: ${scores.joinToString(", ")}")
        return scores.toIntArray()
    }

}