package com.shudss00.enigma

enum class RotorType(val type: Int, val wiring: String, val turnovers: Char, val notch: Char) {
    RotorI(1, "EKMFLGDQVZNTOWYHXUSPAIBRCJ",  'R', 'Q'),
    RotorII(2, "AJDKSIRUXBLHWTMCQGZNPYFVOE", 'F', 'E'),
    RotorIII(3,"BDFHJLCPRTXVZNYEIWGAKMUSQO", 'W', 'V'),
    RotorIV(4, "ESOVPZJAYQUIRHXLNFTGKDCMWB", 'K', 'J'),
    RotorV(5, "VZBRGITYUPSDNHLXAWMJQOFECK", 'A', 'Z')
}

enum class ReflectorType(val type: Int, val wiring: String) {
    UWK_A(1, "EJMZALYXVBWFCRQUONTSPIKHGD"),
    UWK_B(2, "YRUHQSLDPXNGOKMIEBFZCWVJAT"),
    UWK_C(3, "FVPJIAOYEDRZXWGCTKUQSBNMHL")
}