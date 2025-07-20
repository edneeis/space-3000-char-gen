package com.space.core

class Ability(val name: String, var baseScore: Int = 0) {
    var score: Int = baseScore
    var modifier: Int = 0
    var modifiers: Array<Modifier> = emptyArray()

    fun calculateScore() {
        modifier =  modifiers.filter { it.enabled }.sumOf { it.scoreModifier }
        score = baseScore + modifier
    }
}