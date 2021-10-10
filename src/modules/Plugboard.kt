package com.shudss00.enigma.modules

import com.shudss00.enigma.ALPHABET

class Plugboard(mapping: Map<Char, Char>) {
    var base = ALPHABET
    var mapping: MutableMap<Char, Char> = mutableMapOf()
    init {
        base.forEach { m ->
            this.mapping[m] = m
        }
        mapping.forEach { m ->
            this.mapping[m.key] = m.value
            this.mapping[m.value] = m.key
        }
    }
    /**
     * Return the index of the [char].
     */
    fun forward(char: Char) =
        base.indexOf(mapping[char] ?: ' ')
    /**
     * Return the character of the [index].
     */
    fun reverse(index: Int) =
        this.mapping[base[index]] ?: ' '
}