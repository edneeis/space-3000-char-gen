package com.space.core

open class AbilityModifier(scoreModifier: Int = 0, var abilityName: String = "") : Modifier(scoreModifier) {
    init {
        category = "Ability"
    }

    override fun appliesTo(obj: Any): Boolean {
        if (obj !is Ability) return false
        return obj.name.equals(abilityName, ignoreCase = true)
    }
}