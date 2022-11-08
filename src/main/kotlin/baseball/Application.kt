package baseball
import java.util.Random

fun make_random() : MutableList<Int> {
    val random = Random()
    var list = mutableListOf<Int>()

    while (list.size < 3){
            val anyNumber = random.nextInt(10)+1
            if (list.contains(anyNumber)){
                continue
            }
            list.add(anyNumber)
    }

    return list
}

fun main() {

    var input:String

    while(true){
        var number = make_random()
    }

}
