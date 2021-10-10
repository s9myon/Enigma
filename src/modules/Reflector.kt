package com.shudss00.enigma.modules

import com.shudss00.enigma.ALPHABET
import com.shudss00.enigma.ReflectorType

class Reflector(val setting: ReflectorType) {
    private var base = ALPHABET
    private var sequence = setting.wiring
    /**
     * Passthrough the reflector
     */
    fun forward(index: Int) : Int =
        sequence.indexOf(base[index])
}