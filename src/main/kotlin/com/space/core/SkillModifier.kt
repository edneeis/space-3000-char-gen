package com.space.core

class SkillModifier(scoreModifier: Int = 0, var skillName: String = "") : Modifier(scoreModifier) {
    init {
        category = "Skill"
    }

    override fun appliesTo(obj: Any): Boolean {
        if (obj !is Skill) return false
        return obj.name.equals(skillName, ignoreCase = true)
    }

}