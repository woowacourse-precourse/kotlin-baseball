package baseball

class StringLengthVerifier(private val length: Int) : Verifier<String>() {
    override fun verify(input: String) {
        if (input.length != length) {
            throw IllegalArgumentException("Input length is not ${this.length}")
        }
    }
}