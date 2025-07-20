package com.space.core

class Character {
    var name: String = ""
    var species: Species = Species() //TODO: Complete species object
    var level: Int = 1
    var healthPoints: Int = 0 //TODO: Make health points object and modifiers
    var magicPoints: Int = 0 //TODO: Make magic points object and modifiers
    var armorPoints: Int = 0 //TODO: Make armor points object
    var armorClass: Int = 0  //TODO: Make armor class object and modifiers
    var resistances: MutableList<String> = mutableListOf()
    var vulnerabilities: MutableList<String> = mutableListOf()
    var conditions: MutableList<String> = mutableListOf()
    var abilities: Array<Ability> = arrayOf(
        Ability("Strength").apply{
            skills = arrayOf(
                Skill("Melee", baseAbility = this),
                Skill("Unarmed", baseAbility = this),
                Skill("Athletics", baseAbility = this),
                Skill("Intimidation", baseAbility = this),
                Skill("Gunner", baseAbility = this)
            )
        },
        Ability("Dexterity").apply {
            skills = arrayOf(
                Skill("Ranged", baseAbility = this),
                Skill("Dodge", baseAbility = this),
                Skill("Stealth", baseAbility = this),
                Skill("Sleight of Hand", baseAbility = this)
            )
        },
        Ability("Constitution").apply {
            skills = arrayOf(
                Skill("Crafting", baseAbility = this),
                Skill("Navigation", baseAbility = this),
                Skill("History", baseAbility = this),
                Skill("Repair", baseAbility = this)
            )
        },
        Ability("Intelligence").apply{
            skills = arrayOf(
                Skill("Investigation", baseAbility = this),
                Skill("Medicine", baseAbility = this),
                Skill("Technology", baseAbility = this),
                Skill("Hacking", baseAbility = this),
                Skill("Engineering", baseAbility = this)
            )
        },
        Ability("Spirituality").apply {
            skills = arrayOf(
                Skill("Arcana", baseAbility = this),
                Skill("Insight", baseAbility = this),
                Skill("Religion", baseAbility = this),
                Skill("Nature", baseAbility = this),
                Skill("Tracking", baseAbility = this)
            )
        },
        Ability("Charisma").apply {
            skills = arrayOf(
                Skill("Manipulation", baseAbility = this),
                Skill("Performance", baseAbility = this),
                Skill("Animal Handling", baseAbility = this),
                Skill("Leadership", baseAbility = this)
            )
        }
    )
//    var skills: Array<Skill> = arrayOf(
//        Skill("Melee"),
//        Skill("Unarmed"),
//        Skill("Athletics"),
//        Skill("Intimidation"),
//        Skill("Gunner"),
//        Skill("Ranged"),
//        Skill("Dodge"),
//        Skill("Stealth"),
//        Skill("Sleight of Hand"),
//        Skill("Crafting"),
//        Skill("Navigation"),
//        Skill("History"),
//        Skill("Repair"),
//        Skill("Investigation"),
//        Skill("Medicine"),
//        Skill("Technology"),
//        Skill("Hacking"),
//        Skill("Engineering"),
//        Skill("Arcana"),
//        Skill("Insight"),
//        Skill("Religion"),
//        Skill("Nature"),
//        Skill("Tracking"),
//        Skill("Manipulation"),
//        Skill("Performance"),
//        Skill("Animal Handling"),
//        Skill("Leadership"),
//    )
    var features: MutableList<Feature> = mutableListOf() //TODO: Complete feature object
    var perks: MutableList<Perk> = mutableListOf() //TODO: Complete perk object
    var credits: Int = 0
    var equipment: MutableList<Equipment> = mutableListOf() //TODO: Complete equipment object
    var weapons: MutableList<Weapon> = mutableListOf() //TODO: Complete weapon object
    var armor: MutableList<Armor> = mutableListOf() //TODO: Complete armor object
    var spells: MutableList<Spell> = mutableListOf() //TODO: Complete spell object
    var description: Description = Description()

    var modifiers: MutableList<Modifier> = mutableListOf()

    fun getAbilityByName(name: String): Ability? {
        return abilities.firstOrNull { it.name.equals(name, ignoreCase = true) }
    }

    fun getSkillByName(name: String): Skill? {
        return abilities.flatMap { it.skills.asList() }
            .firstOrNull { it.name.equals(name, ignoreCase = true) }
    }

    fun calculateModifiers() {
        for (ability in abilities) {
            ability.modifiers = modifiers.filter { it.appliesTo(ability) }.toTypedArray()
            ability.calculateScore()

            for (skill in ability.skills) {
                skill.modifiers = modifiers.filter { it.appliesTo(skill) }.toTypedArray()
                skill.calculateScore()
            }
        }
    }
}

