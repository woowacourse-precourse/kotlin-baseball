package baseball
fun main() {
    val gp = GamePrint()
    val gl = GameLogic()

    var count = 0
    while(true){
        gp.gameStart()
        gl.gameStart()
        while (true){
            gp.inputNum()
            gl.userInput()
            gl.userNumToList(gl.number)
            gl.comparison()
            gp.result()
            count += 1
            if(count == 10){
                break
            }
        }
        break
    }
}
