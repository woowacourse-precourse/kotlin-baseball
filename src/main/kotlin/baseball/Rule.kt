package baseball

class Rule {
    fun isCorrectNumber(player: String): Boolean {
        return !(wrongLength(player) || wrongRange(player) || isReduplication(player))
    }

    private fun wrongLength(player: String): Boolean {
        return when(player.length) {
            3 -> false
            else -> true
        }
    }

    private fun wrongRange(player: String): Boolean {
        for (c in player) {
            if (c < '0' || c > '9')
                return true
        }
        return false
    }

    // 3. 서로 다른 수를 입력하지 않았을 경우 (=중복된 수를 입력할 경우)
    private fun isReduplication(player: String): Boolean {
        for(i in 0 until player.length - 1) {
            if(player[i] == player[i+1])
                return true
        }
        return false

    }
}