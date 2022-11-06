package baseball

private const val GAMESTART=1
private const val GAMEEND=2

fun main() {
    var userChoice=1
    println("숫자 야구 게임을 시작합니다.")

    while(userChoice==GAMESTART){
        userChoice= entireGame()
    }
}

fun entireGame():Int {

    return 0
}
