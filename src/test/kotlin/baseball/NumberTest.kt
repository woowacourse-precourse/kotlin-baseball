//package baseball
//
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.assertThrows
//
//class NumberTest {
//    @Test
//    fun `isOutOfRange 메서드 사용시 1~9 사이의 숫자를 입력하지 않을 경우 true 반환`() {
//        val input = listOf(1, 2, 0)
//        val result = isOutOfRange(input)
//        assertThat(result).isEqualTo(true)
//    }
//
//    @Test
//    fun `isOutOfSize 메서드 사용시 입력 리스트 크기가 3이 아닐 경우 true 반환`() {
//        val input = listOf(1, 2, 7, 8, 9)
//        val result = isOutOfSize(input)
//        assertThat(result).isEqualTo(true)
//    }
//
//    @Test
//    fun `hasDuplicatedNumber 메서드 사용시 중복된 숫자를 입력할 경우 true 반환`() {
//        val input = listOf(1, 5, 5)
//        val result = hasDuplicatedNumber(input)
//        assertThat(result).isEqualTo(true)
//    }
//
//    @Test
//    fun `1~9 사이의 숫자를 입력하지 않거나, 리스트 크기가 3이 아니거나, 중복된 숫자를 입력할 경우 예외 발생`() {
//        val input = listOf(1, 5, 5, 0)
//        assertThrows<IllegalArgumentException> {
//            isOutOfRange(input) || isOutOfSize(input) || hasDuplicatedNumber(input)
//        }
//    }
//
//    @Test
//    fun `게임 종료 시 1~2 사이의 숫자를 입력하지 않을 경우 예외 발생`() {
//        val input = 4
//        assertThrows<IllegalArgumentException> {
//            input !in 1..2
//        }
//    }
//
//    private fun isOutOfRange(input: List<Int>): Boolean = input.contains(0)
//
//    private fun isOutOfSize(input: List<Int>): Boolean = (input.size != 3)
//
//    private fun hasDuplicatedNumber(input: List<Int>): Boolean = (input.size != input.distinct().count())
//}