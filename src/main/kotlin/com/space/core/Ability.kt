package com.space.core

class Ability(val name: String, var baseScore: Int = 0) {
    var score: Int = baseScore
    var modifier: Int = 0
    var bonus: Int = 0
    var modifiers: Array<Modifier> = emptyArray()
    var skills: Array<Skill> = emptyArray()

    fun calculateModifier(): Int {
        return when {
            score <= 5 -> -3
            score >= 40 -> 15
            else -> ((score - 6) / 2) - 2
        }
    }

    fun calculateScore() {
        bonus =  modifiers.filter { it.enabled }.sumOf { it.scoreModifier }
        score = baseScore + bonus
        modifier = calculateModifier()
    }
}