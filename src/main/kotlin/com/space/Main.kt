import com.space.core.*

fun main() {

    val gen = Generator()

    val scores = gen.RollAbilityScores()

    val char = Character()
    char.name = "Hero"

    for (i in char.abilities.indices) {
        val ability = char.abilities[i]
        ability.baseScore = scores[i]
        println("Ability: ${ability.name}, Base Score: ${ability.baseScore}")
    }
    //char.getAbilityByName("Strength")?.BaseScore = 10


    char.modifiers.add(AbilityModifier().apply {
        description = "Super Strength Feature"
        scoreModifier = 5
        abilityName = "Strength"
    })

    char.modifiers.add(AbilityModifier().apply {
        description = "Human Race Bonus"
        scoreModifier = 1
        abilityName = "Strength"
    })
    char.modifiers.add(AbilityModifier().apply {
        description = "Human Race Bonus"
        scoreModifier = 1
        abilityName = "Dexterity"
    })
    char.modifiers.add(AbilityModifier().apply {
        description = "Human Race Bonus"
        scoreModifier = 1
        abilityName = "Constitution"
    })
    char.modifiers.add(AbilityModifier().apply {
        description = "Human Race Bonus"
        scoreModifier = 1
        abilityName = "Intelligence"
    })
    char.modifiers.add(AbilityModifier().apply {
        description = "Human Race Bonus"
        scoreModifier = 1
        abilityName = "Spirituality"
    })
    char.modifiers.add(AbilityModifier().apply {
        description = "Human Race Bonus"
        scoreModifier = 1
        abilityName = "Charisma"
    })

    char.modifiers.add(SkillModifier().apply {
        description = "Strength Bonus"
        scoreModifier = 2
        skillName = "Melee"
    })

    char.calculateModifiers()

    println("Character: ${char.name}")
    for (i in char.abilities.indices) {
        val ability = char.abilities[i]
        println("Ability: ${ability.name}, Base Score: ${ability.baseScore}, Score: ${ability.score}, Modifier: ${ability.modifier}, Modifiers: ${ability.modifiers.joinToString { "${it.description} (+${it.scoreModifier})" }}")
        for (i in ability.skills.indices) {
            val skill = ability.skills[i]
            println("Skill: ${skill.name}, Base Score: ${skill.baseScore}, Score: ${skill.score}, Modifier: ${skill.modifier}, Modifiers: ${skill.modifiers.joinToString { "${it.description} (+${it.scoreModifier})" }}")
        }
    }
}