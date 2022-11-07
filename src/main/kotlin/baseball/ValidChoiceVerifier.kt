package baseball

class ValidChoiceVerifier(private val validChoices: List<String>) : Verifier<String>() {
    override fun verify(input: String) {
        if (!validChoices.contains(input)) {
            throw IllegalArgumentException("Input is invalid choice")
        }
    }
}