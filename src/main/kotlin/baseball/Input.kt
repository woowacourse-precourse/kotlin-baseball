package baseball

interface Input {
    fun get(): String

    fun validCheck(input: String, validators: List<Verifier<String>>) {
        val inputValidator = InputValidator(validators)
        inputValidator.validate(input)
    }
}