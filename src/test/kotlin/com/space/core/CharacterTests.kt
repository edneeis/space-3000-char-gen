package com.space.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CharacterTests {

    @Test
    fun `test strength is initialized to 20 with +5 modifier`() {
        val char = Character()
        char.getAbilityByName("Strength")?.baseScore = 20
        char.calculateModifiers()
        val str = char.getAbilityByName("Strength")
        assertEquals(20, str?.score, "Strength score should be 20")
        assertEquals(5, str?.modifier, "Strength modifier should be 5")
    }

    @Test
    fun `test strength is initialized and adjusted for features`() {
        val char = Character()
        char.getAbilityByName("Strength")?.baseScore = 20
        char.modifiers.add(AbilityModifier().apply {
            description = "Super Strength Feature"
            scoreModifier = 5
            abilityName = "Strength"
        })
        char.calculateModifiers()
        val str = char.getAbilityByName("Strength")
        assertEquals(25, str?.score, "Strength score should be 25")
        assertEquals(7, str?.modifier, "Strength modifier should be 7")
    }


}