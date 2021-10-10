package com.shudss00.enigma

import com.shudss00.enigma.modules.Enigma
import java.lang.Exception
import java.util.*

fun main() {
    val machine = Enigma()

    var ciphertext = ""

    try {
        machine.printSetup()
        val buffer = Scanner(System.`in`)
        print("\nInput a text: ")
        var plaintext = buffer.next()
        buffer.close()
        println("Plaintext: $plaintext")

        // Encode message
        plaintext.forEach {
            ciphertext += machine.encode(it)
        }
        println("Ciphertext: $ciphertext")

        // Reset and Decode same message
        machine.reset()
        plaintext = ""
        ciphertext.forEach {
            plaintext += machine.encode(it)
        }
        println("Plaintext: $plaintext")
    } catch (e: Exception) {
        println(e.stackTrace)
    }
}