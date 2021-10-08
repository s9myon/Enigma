class Rotor<T>(private val setting: Int = 1, private val ringOffset: Int = 0) {
    private var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val settings = mapOf(
        1 to arrayOf("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "R", "Q"),
        2 to arrayOf("AJDKSIRUXBLHWTMCQGZNPYFVOE", "F", "E"),
        3 to arrayOf("BDFHJLCPRTXVZNYEIWGAKMUSQO", "W", "V"),
        4 to arrayOf("ESOVPZJAYQUIRHXLNFTGKDCMWB", "K", "J"),
        5 to arrayOf("VZBRGITYUPSDNHLXAWMJQOFECK", "A", "Z")
    )
    private val turnovers = settings.getValue(setting)[1]
    val notch = settings.getValue(setting)[2]
    private var sequence: String = "EKMFLGDQVZNTOWYHXUSPAIBRCJ"
    private var turnover = false

    init {
        reset()
    }

    private fun reset() {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        sequence = sequenceSettings()
        ringSettings()
    }

    private fun sequenceSettings(): String =
        settings[setting]?.get(0) ?: "EKMFLGDQVZNTOWYHXUSPAIBRCJ"

    private fun ringSettings() {
        for (i in 0..ringOffset) {
            reset()
        }
    }

    fun forward(index: Int) =
        alphabet.indexOf(sequence[index])

    fun reverse(index: Int) =
        sequence.indexOf(alphabet[index])

    fun rotate() {
        alphabet = alphabet.drop(1) + alphabet[0]
        sequence = sequence.drop(1) + sequence[0]
        if (alphabet[0] in turnovers){
            turnover = true
        }

    }
}