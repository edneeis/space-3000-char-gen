package com.space.core

class Skill(val name: String, var baseScore: Int = 0, val baseAbility: Ability? = null) {
    var score: Int = baseScore
    var modifier: Int = 0
    var modifiers: Array<Modifier> = emptyArray()

    fun calculateScore() {
        modifier = (baseAbility?.modifier ?: 0) + modifiers.filter { it.enabled }.sumOf { it.scoreModifier }
        score = baseScore + modifier
    }
}