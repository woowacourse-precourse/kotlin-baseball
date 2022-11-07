package baseball

class Rule {
    fun isCorrectNumber(player: String): Boolean {
        // 1. 3자리 수가 아닐 경우 false
        if (player.length != 3)
            return false
        // 2. 1-9의 범위를 벗어난 숫자가 아닐 경우 false
        for (c in player) {
            if (c < '0' || c > '9')
                return false
        }
        // 3. 서로 다른 수를 입력하지 않았을 경우 (=중복된 수를 입력할 경우) false
        if (player[0] == player[1] || player[0] == player[1] ||
            player[1] == player[2]
        )
            return false

        return true
    }
}