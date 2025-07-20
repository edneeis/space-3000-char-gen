package com.space.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AbilityTests {

    @Test
    fun `test Ability creation`() {
        val ability = Ability("Kotlin", 5)
        assertEquals("Kotlin", ability.name)
        assertEquals(5, ability.score)
    }

    @Test
    fun `strength ability score is calculated correctly`() {
        val ability = Ability("Strength")
        ability.baseScore = 10
        ability.modifiers = arrayOf(AbilityModifier(5), Modifier(-2))
        ability.calculateScore()
        assertEquals(13, ability.score, "Strength score should be calculated as 10 + 5 - 2")
    }

    @Test
    fun `ability score is zero when no base score or modifiers`() {
        val ability = Ability("Dexterity")
        ability.calculateScore()
        assertEquals(0, ability.score, "Ability score should be 0 when base score and modifiers are 0")
    }

    @Test
    fun `ability score handles negative modifiers correctly`() {
        val ability = Ability("Constitution")
        ability.baseScore = 15
        ability.modifiers = arrayOf(Modifier(-5), Modifier(-3))
        ability.calculateScore()
        assertEquals(7, ability.score, "Ability score should handle negative modifiers correctly")
    }

    @Test
    fun `ability score handles empty modifiers array`() {
        val ability = Ability("Intelligence")
        ability.baseScore = 20
        ability.modifiers = emptyArray()
        ability.calculateScore()
        assertEquals(20, ability.score, "Ability score should equal base score when no modifiers are present")
    }

    @Test
    fun `ability score handles large number of modifiers`() {
        val ability = Ability("Charisma")
        ability.baseScore = 50
        ability.modifiers = Array(100) { Modifier(1) }
        ability.calculateScore()
        assertEquals(150, ability.score, "Ability score should handle a large number of modifiers correctly")
    }
    @Test
    fun `modifier is not calculated in score when enabled is false`() {
        val ability = Ability("Wisdom")
        ability.baseScore = 12
        val disabledModifier = Modifier(10).apply { enabled = false }
        val enabledModifier = Modifier(3).apply { enabled = true }
        ability.modifiers = arrayOf(disabledModifier, enabledModifier)
        ability.calculateScore()
        assertEquals(15, ability.score, "Score should only include enabled modifiers")
    }

}