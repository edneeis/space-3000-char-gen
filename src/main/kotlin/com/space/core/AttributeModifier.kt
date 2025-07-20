package com.space.core

class AttributeModifier {

    var category: String = ""
    var description: String = ""
    var amount: Int = 0

    fun modify(attribute: Attribute, amount: Int) {
        attribute.baseValue += amount
        println("${attribute.name} modified by $amount. New value: ${attribute.baseValue}")
    }
}