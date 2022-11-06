package baseball

class InputValidator<T>(private val validators: List<Verifier<T>>) {
    fun validate(input: T) {
        for (validator in validators) {
            validator.verify(input)
        }
    }
}