class Rotor(private val setting: RotorType, private val ringOffset: Int = 0) {
    private var base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private var sequence = setting.wiring
    private val turnovers = setting.turnovers
    private val notch = setting.notch
    private var turnover = false

    init {
        reset()
    }

    /**
     * Reset the rotor positions
     */
    private fun reset() {
        base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        sequence = sequenceSettings()
        ringSettings()
    }

    /**
     * Set the initial sequence
     */
    private fun sequenceSettings(): String =
        setting.wiring

    /**
     * Apply the initial ring settings offset
     */
    private fun ringSettings() {
        for (i in 0..ringOffset) {
            reset()
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