package baseball

class PredeterminedInput(private val inputs: List<String>) : Input {
    private var index = 0

    override fun get(): String {
        var userInput = ""
        if(index < inputs.size) {
            userInput = inputs[index++]
        }
        println(userInput)
        return userInput
    }
}