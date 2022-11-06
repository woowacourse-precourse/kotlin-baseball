package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BaseballGameTest {
    private val baseballGame = BaseballGame()

    @Test
    fun `유저의 숫자를 리스트로 반환하는 함수`(){
        val input = 159
        val result = listOf(1, 5, 9)
        assertThat(baseballGame.getUserNumberList(input)).isEqualTo(result)
    }

    @Test
    fun `1볼 일 때의 결과 string`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(2, 1, 7)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("1볼")
    }

    @Test
    fun `1스트라이크 일 때의 결과 string`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(1, 6, 7)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("1스트라이크")
    }

    @Test
    fun `1볼 1스트라이크 일 때의 결과 string`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(2, 1, 9)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("1볼 1스트라이크")
    }

    @Test
    fun `2볼 1스트라이크 일 때의 결과 string`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(5, 1, 9)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("2볼 1스트라이크")
    }

    @Test
    fun `2스트라이크 일 때의 결과 string`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(1, 8, 9)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("2스트라이크")
    }

    @Test
    fun `2볼 일 때의 결과 string`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(5, 9, 3)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("2볼")
    }

    @Test
    fun `3볼 일 때의 결과 string`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(5, 9, 1)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("3볼")
    }

    @Test
    fun `아무것도 일치하지 않을 때의 결과 string`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(4, 2, 3)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("낫싱")
    }

    @Test
    fun `3스트라이크 일 때 결과`(){
        val computerList = mutableListOf(1, 5, 9)
        val userList = mutableListOf(1, 5, 9)
        assertThat(baseballGame.getResultString(computerList, userList)).isEqualTo("3스트라이크")
    }


}