package com.shudss00.enigma.modules

import com.shudss00.enigma.ALPHABET
import com.shudss00.enigma.RotorType

class Rotor(val setting: RotorType, private val ringOffset: Int = 0) {
    var base = ALPHABET
    private var sequence = setting.wiring
    private val turnovers = setting.turnovers
    val notch = setting.notch
    var turnover = false

    init {
        reset()
    }

    /**
     * Reset the rotor positions
     */
    fun reset() {
        base = ALPHABET
        sequence = setting.wiring
        ringSettings()
    }

    /**
     * Apply the initial ring settings offset
     */
    private fun ringSettings() {
        for (i in 0..ringOffset) {
            rotate()
        }
    }

    /**
     * Pass [index] from right to left forward through the rotor
     */
    fun forward(index: Int) : Int =
        base.indexOf(sequence[index])

    /**
     * Pass [index] from left to right back through the rotor
     */
    fun reverse(index: Int) : Int =
        sequence.indexOf(base[index])

    /**
     * Cycle the rotor to 1 position
     */
    fun rotate() {
        base = base.drop(1) + base[0]
        sequence = sequence.drop(1) + sequence[0]
        if (base[0] == turnovers){
            turnover = true
        }

    }
}