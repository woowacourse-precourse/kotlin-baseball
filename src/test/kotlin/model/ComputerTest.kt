package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import util.Constants.MAX_SIZE

class ComputerTest {
    private val computer = Computer()

    @Test
    fun `랜덤으로 생성된 리스트 크기 확인`() {
        computer.registerNumbersToList()
        val computerList = computer.randomNumberList
        assertThat(computerList.size).isEqualTo(MAX_SIZE)
    }

    @Test
    fun `랜덤 한 3개의 서로 다른 숫자 리스트 생성`() {
        val computer = Computer()
        computer.registerNumbersToList()
        val computerList = computer.randomNumberList
        assertThat(computerList).doesNotHaveDuplicates()
    }

}