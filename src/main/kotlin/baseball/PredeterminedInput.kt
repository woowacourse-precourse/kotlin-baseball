package baseball

class PredeterminedInput(private val inputs: List<String>) : Input {
    private var index = 0

    override fun get(): String {
        if(index < inputs.size) {
            return inputs[index++]
        }
        return ""
    }
}