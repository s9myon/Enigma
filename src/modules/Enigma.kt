package com.shudss00.enigma.modules

import com.shudss00.enigma.ALPHABET
import com.shudss00.enigma.ReflectorType
import com.shudss00.enigma.RotorType

class Enigma {
    var numcycles = 0
    val rotors = mutableListOf<Rotor>()

    /**
     * Settings for the rotors
     */
    val rotorSettings = arrayOf(
        RotorType.RotorIII,
        RotorType.RotorII,
        RotorType.RotorI
    )

    /**
     * Setting for the reflector
     */
    val reflectorSetting = ReflectorType.UWK_B

    /**
     * Settings for the plugboard
     */
    val plugboardSetting = mapOf<Char, Char>()

    val reflector = Reflector(reflectorSetting)
    val plugboard = Plugboard(plugboardSetting)
    init {
        rotorSettings.forEach {
            rotors.add(Rotor(it))
        }
    }

    /**
     * Prints initial setup information
     */
    fun printSetup() {
        println("\nRotor sequence: (right to left)")
        rotors.forEach {
            println("${it.setting.name} \t ${it.setting.wiring}")
        }
        println("\nReflector sequence:")
        println("${reflector.setting.name} \t ${reflector.setting.wiring}")
        println("\nPlugboard settings:")
        println("${plugboard.mapping}")
    }

    /**
     * Reset to initial state
     */
    fun reset() {
        numcycles = 0
        rotors.forEach {
            it.reset()
        }
    }

    /**
     * Run a cycle of the enigma with one character
     */
    fun encode(c: Char) : Char {
        var char = c.uppercaseChar()
        if (char !in ALPHABET) {
            return char
        }

        rotors[0].rotate()

        // Double step
        if (rotors[1].base[0] == rotors[1].notch) {
            rotors[1].rotate()
        }

        // Normal stepping
        for (i in 0 until rotors.lastIndex) {
            if (rotors[i].turnover) {
                rotors[i].turnover = false
                rotors[i + 1].rotate()
            }
        }

        // Passthrough the plugboard forward
        var index = plugboard.forward(char)

        // Move through the rotors forward
        rotors.forEach {
            index = it.forward(index)
        }

        // Pass through the reflector
        index = reflector.forward(index)

        // Move back through rotors in reverse
        rotors.reversed().forEach {
            index = it.reverse(index)
        }

        // Passthrought the plugboard reverse
        char = plugboard.reverse(index)

        return char
    }
}