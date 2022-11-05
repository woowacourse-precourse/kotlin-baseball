package baseball

abstract class Verifier<T> {
    abstract fun verify(input: T)
}