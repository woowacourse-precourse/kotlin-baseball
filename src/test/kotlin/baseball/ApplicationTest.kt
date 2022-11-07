package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `게임종료 후 재시작`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            }, 1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `문자열 길이 예외 테스트`() {
        val stringLengthVerifier = StringLengthVerifier(3)

        assertSimpleTest {
            assertDoesNotThrow { stringLengthVerifier.verify("123") }

            assertThrows<IllegalArgumentException> {
                stringLengthVerifier.verify(
                    "1234"
                )
            }
        }
    }

    @Test
    fun `문자열이 1 ~ 9에 포함된 문자로만 이루어져 있는지 확인하는 기능 예외 테스트`() {
        val oneToNineOnlyVerifier = OneToNineOnlyVerifier()

        assertSimpleTest {
            assertDoesNotThrow { oneToNineOnlyVerifier.verify("123") }

            assertThrows<IllegalArgumentException> {
                oneToNineOnlyVerifier.verify(
                    "120"
                )
            }

            assertThrows<IllegalArgumentException> {
                oneToNineOnlyVerifier.verify(
                    "12a"
                )
            }
        }
    }

    @Test
    fun `문자열 속 문자가 모두 다른 문자인지 확인하는 기능 예외 테스트`() {
        val noSameCharacterVerifier = NoSameCharacterVerifier()

        assertSimpleTest {
            assertDoesNotThrow { noSameCharacterVerifier.verify("123") }

            assertThrows<IllegalArgumentException> {
                noSameCharacterVerifier.verify(
                    "122"
                )
            }
        }
    }

    @Test
    fun `문자열이 선택지 안에 있는지 확인하는 기능 예외 테스트`() {
        val validChoiceVerifier = ValidChoiceVerifier(listOf("1", "2"))

        assertSimpleTest {
            assertDoesNotThrow { validChoiceVerifier.verify("1") }

            assertDoesNotThrow { validChoiceVerifier.verify("2") }

            assertThrows<IllegalArgumentException> {
                validChoiceVerifier.verify(
                    "3"
                )
            }
        }
    }

    @Test
    fun `주어진 문자열 유효성 검사`() {
        val inputValidator = InputValidator(
            listOf(
                StringLengthVerifier(3),
                OneToNineOnlyVerifier(),
                NoSameCharacterVerifier(),
            )
        )
        assertDoesNotThrow { inputValidator.validate("369") }
        assertThrows<IllegalArgumentException> { inputValidator.validate("12") }
        assertThrows<IllegalArgumentException> { inputValidator.validate("101") }
        assertThrows<IllegalArgumentException> { inputValidator.validate("abc") }
        assertThrows<IllegalArgumentException> { inputValidator.validate("111") }

        val choiceValidator = InputValidator(
            listOf(
                StringLengthVerifier(1),
                ValidChoiceVerifier(listOf("1", "2")),
            )
        )
        assertDoesNotThrow { choiceValidator.validate("1") }
        assertDoesNotThrow { choiceValidator.validate("2") }
        assertThrows<IllegalArgumentException> { choiceValidator.validate("12") }
        assertThrows<IllegalArgumentException> { choiceValidator.validate("01") }
        assertThrows<IllegalArgumentException> { choiceValidator.validate("0") }
        assertThrows<IllegalArgumentException> { choiceValidator.validate("3") }
    }

    @Test
    fun `게임 시작 안내`() {
        val guide = Guide()

        guide.start()

        assertThat(output()).contains("숫자 야구 게임을 시작합니다.")
    }

    @Test
    fun `무작위로 생성된 숫자 유효성 검사`() {
        val randomNumberGenerator = RandomNumberGenerator()
        val numberValidator = InputValidator(
            listOf(
                OneToNineOnlyVerifier(),
                NoSameCharacterVerifier(),
            )
        )

        val numbers = randomNumberGenerator.generateNumbers(3)

        assertThat(numbers.size).isEqualTo(3)
        assertDoesNotThrow { numberValidator.validate(numbers.joinToString("")) }
    }

    @Test
    fun `무작위 숫자 생성`() {
        val expect = listOf(1, 3, 5)
        val expectedNumberGenerator = ExpectedNumberGenerator(expect)

        val result = expectedNumberGenerator.generateNumbers(3)

        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `사용자 숫자 입력 안내`() {
        val guide = Guide()

        guide.input()

        assertThat(output()).contains("숫자를 입력해주세요 :")
    }

    @Test
    fun `사용자 입력 테스트`() {
        val expected = listOf("246", "135", "1", "597", "589", "2")
        val predeterminedInput = PredeterminedInput(expected)

        val result = mutableListOf<String>()
        for (index in expected.indices) {
            result.add(predeterminedInput.get())
        }

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `사용자 입력 유효성 검사`() {
        val predeterminedInput = PredeterminedInput(listOf("123", "1234", "1", "2", "3"))
        val numbersValidator = listOf(
            StringLengthVerifier(3),
            OneToNineOnlyVerifier(),
            NoSameCharacterVerifier(),
        )
        val choiceValidator = listOf(
            StringLengthVerifier(1),
            ValidChoiceVerifier(listOf("1", "2")),
        )

        assertDoesNotThrow { predeterminedInput.validCheck(predeterminedInput.get(), numbersValidator) }
        assertThrows<IllegalArgumentException> {
            predeterminedInput.validCheck(
                predeterminedInput.get(),
                numbersValidator,
            )
        }
        assertDoesNotThrow { predeterminedInput.validCheck(predeterminedInput.get(), choiceValidator) }
        assertDoesNotThrow { predeterminedInput.validCheck(predeterminedInput.get(), choiceValidator) }
        assertThrows<IllegalArgumentException> {
            predeterminedInput.validCheck(
                predeterminedInput.get(),
                choiceValidator,
            )
        }
    }

    @Test
    fun `사용자 입력 정수 리스트로 변환`() {
        val userInput = "189"
        val converter = StringToIntegerList()
        val expected = listOf(1, 8, 9)

        val result = converter.convert(userInput)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `볼, 스트라이크 개수 세기`() {
        val generator = ExpectedNumberGenerator(listOf(1, 3, 5))
        val computer = Computer(generator)

        computer.generateNumbers()
        val nothing = computer.countBallsStrikes(listOf(2, 4, 6))
        val strikes = computer.countBallsStrikes(listOf(1, 3, 5))
        val ballsStrikes = computer.countBallsStrikes(listOf(1, 5, 9))

        assertThat(nothing.balls).isEqualTo(0)
        assertThat(nothing.strikes).isEqualTo(0)
        assertThat(strikes.balls).isEqualTo(0)
        assertThat(strikes.strikes).isEqualTo(3)
        assertThat(ballsStrikes.balls).isEqualTo(1)
        assertThat(ballsStrikes.strikes).isEqualTo(1)
    }

    @Test
    fun `볼, 스트라이크 개수 안내`() {
        val guide = Guide()
        val generator = ExpectedNumberGenerator(listOf(1, 3, 5))
        val computer = Computer(generator)

        computer.generateNumbers()
        val nothing = computer.countBallsStrikes(listOf(2, 4, 6))
        val strikes = computer.countBallsStrikes(listOf(1, 3, 5))
        val ballsStrikes = computer.countBallsStrikes(listOf(1, 5, 9))

        guide.ballsStrikes(nothing)
        assertThat(output()).contains("낫싱")
        guide.ballsStrikes(strikes)
        assertThat(output()).contains("3스트라이크")
        guide.ballsStrikes(ballsStrikes)
        assertThat(output()).contains("1볼 1스트라이크")
    }

    @Test
    fun `사용자가 게임을 이겼는지 확인`() {
        val generator = ExpectedNumberGenerator(listOf(1, 3, 5))
        val computer = Computer(generator)

        computer.generateNumbers()
        val lose = computer.countBallsStrikes(listOf(2, 4, 6))
        val win = computer.countBallsStrikes(listOf(1, 3, 5))

        assertThat(computer.isWin(lose)).isEqualTo(false)
        assertThat(computer.isWin(win)).isEqualTo(true)
    }

    @Test
    fun `게임 종료 안내`() {
        val guide = Guide()

        guide.gameOver()

        assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    override fun runMain() {
        main()
    }
}
