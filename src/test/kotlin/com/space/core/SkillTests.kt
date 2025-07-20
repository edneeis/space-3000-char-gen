package com.space.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SkillTests {

    @Test
    fun `test Skill creation`() {
        val skill = Skill("Kotlin", 5)
        assertEquals("Kotlin", skill.name)
        assertEquals(5, skill.score)
    }

    @Test
    fun `test Skill score calculation with enabled and disabled modifiers`() {
        val skill = Skill("Kotlin")
        skill.baseScore = 2
        val enabledModifier = Modifier(scoreModifier = 3).apply { enabled = true }
        val disabledModifier = Modifier(scoreModifier = 5).apply{ enabled = false }
        skill.modifiers = arrayOf(enabledModifier, disabledModifier)
        skill.calculateScore()
        assertEquals(5, skill.score) // 2 + 3, ignores disabled modifier
    }

    @Test
    fun `test Skill score calculation with no modifiers`() {
        val skill = Skill("Kotlin")
        skill.baseScore = 4
        skill.modifiers = emptyArray()
        skill.calculateScore()
        assertEquals(4, skill.score)
    }

}