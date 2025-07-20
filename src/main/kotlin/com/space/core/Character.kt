package com.space.core

class Character {
    var name: String = ""
    var abilities: Array<Ability> = arrayOf(
        Ability("Strength"),
        Ability("Dexterity"),
        Ability("Constitution"),
        Ability("Intelligence"),
        Ability("Spirituality"),
        Ability("Charisma")
    )
    var skills: Array<Skill> = arrayOf(
        Skill("Melee"),
        Skill("Unarmed"),
        Skill("Athletics"),
        Skill("Intimidation"),
        Skill("Gunner"),
        Skill("Ranged"),
        Skill("Dodge"),
        Skill("Stealth"),
        Skill("Sleight of Hand"),
        Skill("Crafting"),
        Skill("Navigation"),
        Skill("History"),
        Skill("Repair"),
        Skill("Investigation"),
        Skill("Medicine"),
        Skill("Technology"),
        Skill("Hacking"),
        Skill("Engineering"),
        Skill("Arcana"),
        Skill("Insight"),
        Skill("Religion"),
        Skill("Nature"),
        Skill("Tracking"),
        Skill("Manipulation"),
        Skill("Performance"),
        Skill("Animal Handling"),
        Skill("Inspiration"),
    )

    var modifiers: MutableList<Modifier> = mutableListOf()

    fun GetAbilityByName(name: String): Ability? {
        return abilities.firstOrNull { it.name.equals(name, ignoreCase = true) }
    }

    fun GetSkillByName(name: String): Skill? {
        return skills.firstOrNull { it.name.equals(name, ignoreCase = true) }
    }

    fun CalculateModifiers() {
        for (ability in abilities) {
            ability.modifiers = modifiers.filter { it.appliesTo(ability) }.toTypedArray()
            ability.CalculateScore()
        }
        for (skill in skills) {
            skill.modifiers = modifiers.filter { it.appliesTo(skill) }.toTypedArray()
            skill.CalculateScore()
        }
    }
}

