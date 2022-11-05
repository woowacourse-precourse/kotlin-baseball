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
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
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

    override fun runMain() {
        main()
    }
}
