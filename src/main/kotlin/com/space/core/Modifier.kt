package com.space.core

open class Modifier(var scoreModifier: Int = 0) {
    var category: String = "General"
    var description: String = ""
    var enabled: Boolean = true

    open fun appliesTo(obj: Any): Boolean {
        return false
    }
}