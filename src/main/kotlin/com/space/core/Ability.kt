package com.space.core

class Ability(val name: String) {
    var baseScore: Int = 0
    var score: Int = 0
    var modifiers: Array<Modifier> = emptyArray()

    fun CalculateScore() {
        score = baseScore + modifiers.filter { it.enabled }.sumOf { it.scoreModifier }
    }
}