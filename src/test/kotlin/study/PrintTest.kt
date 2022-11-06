package study

import baseball.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

val outputStreamCaptor = ByteArrayOutputStream()
val standardOut = System.out

class PrintTest {

    @Test
    fun `printReport 반환 확인_음수`() {
        assertEquals(false, printReport(-1, -1))
    }

    @Test
    fun `printReport 반환 확인_0`() {
        assertEquals(false, printReport(0, 0))
    }

    @Test
    fun `printReport 반환 확인_3스트라이크`() {
        assertEquals(true, printReport(0, 3))
    }


    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `printStart 시작 문구 출력`() {
        printStart()
        assertEquals("숫자 야구 게임을 시작합니다.", outputStreamCaptor.toString().trim())
    }

    @Test
    fun `printNothing 낫싱 문구 출력`() {
        // 전체 실행으로는 문제 발생
        // 개별 실행시 문제 없음
        printNothing()
        assertEquals("낫싱", outputStreamCaptor.toString().trim())
    }

    @Test
    fun `printEnd 3스트라이크 문구 출력`() {
        // 전체 실행으로는 문제 발생
        // 개별 실행시 문제 없음
        printEnd()
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
            outputStreamCaptor.toString().trim())
    }

    @Test
    fun `continueChecker 계속 출력_정상`() {
        val input = "1"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertEquals(true, continueChecker())
    }

    @Test
    fun `continueChecker 종료 출력_정상`() {
        val input = "2"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertEquals(false, continueChecker())
    }

    @Test
    fun `continueChecker 다른 숫자`() {
        val input = "3"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { continueChecker() }
    }

    @Test
    fun `continueChecker 여러 문자열`() {
        val input = "33124"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { continueChecker() }
    }

    @Test
    fun `getInput 테스트_정상`() {
        val input = "123"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertEquals("123", getInput())
    }

    @Test
    fun `getInput 테스트_오류`() {
        val input = "123"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertNotEquals("1", getInput())
    }
}
