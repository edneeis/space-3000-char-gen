package com.space.core

class Attribute {

    var name: String = ""
    var baseValue: Int = 0
    var modifiers: MutableList<AttributeModifier> = mutableListOf()
    var currentValue: Int
        get() = baseValue + modifiers.sumOf { it.amount }
        set(value) {
            baseValue = value - modifiers.sumOf { it.amount }
        }

    constructor(name: String, value: Int) {
        this.name = name
        this.baseValue = value
    }

    fun display() {
        println("$name: $baseValue")
    }
}