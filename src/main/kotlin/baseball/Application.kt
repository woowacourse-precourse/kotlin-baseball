package baseball

fun askRestart(){
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val select= Console.readLine()
    if(select=="1"){
        playGame()
    }
    if(select=="2"){
        endMessage()
    }
}
