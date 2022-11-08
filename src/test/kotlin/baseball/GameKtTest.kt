package baseball

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `Game 파일의` {

    @Nested
    inner class `createComputerNumber 메소드는` {

        @Nested
        inner class `실행하면` {

            @Test
            fun `0을 제외한 서로 다른 3개의 숫자로 이루어진 문자열을 반환한다`() {
                val computerNumber = createComputerNumber()

                assertThat(computerNumber).hasSize(3)
                assertThat(computerNumber).containsAnyOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
                computerNumber.forEach { assertThat(computerNumber).containsOnlyOnce(it.toString()) }
            }
        }
    }
}