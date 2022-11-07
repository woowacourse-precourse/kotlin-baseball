package baseball

class NoSameCharacterVerifier : Verifier<String>() {
    override fun verify(input: String) {
        val components = mutableListOf<Char>()
        for (character in input) {
            if (components.contains(character)) {
                throw IllegalArgumentException("Input has same character")
            }
            components.add(character)
        }
    }
}