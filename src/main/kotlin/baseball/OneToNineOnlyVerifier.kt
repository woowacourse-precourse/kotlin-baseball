package baseball

class OneToNineOnlyVerifier : Verifier<String>() {
    override fun verify(input: String) {
        val regex = Regex("^[1-9]*$")
        if (!regex.matches(input)) {
            throw IllegalArgumentException("Input contains that is not 1 ~ 9")
        }
    }
}