package baseball
import kotlin.text.toInt
import kotlin.io.println
import kotlin.collections.mutableListOf
import camp.nextstep.edu.missionutils.Randoms

var strike :Int = 0
var ball : Int = 0
val inputnum : Array<Int?> = arrayOfNulls<Int>(3)
val comAnswer : Array<Int?> = arrayOfNulls<Int>(3)
fun main(args : ArrayList<String>) :Int
{
    playinggame()
    var doplay : Int = 0
    println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.")
    doplay = readLine()!!.toInt()
    if (doplay == 1) playinggame()
    if (doplay == 2) return 0;
    return 0;
}
fun playinggame() : Int
{
    val comAnswer : Array<Int?> = arrayOfNulls<Int>(3)
    println("���� �߱� ������ �����մϴ�.")
    var i : Int = 0
    println("���ڸ� �Է����ּ��� : ")
    val inputnum : Array<Int?> = arrayOfNulls<Int>(3)
    inputnum[2] = i % 10
    inputnum[1] = i % 10
    inputnum[0] = i % 10
    inputIllegal(inputnum)
    val (strike, ball) = checknum();
    if (print_message() == 0) return (0);
    return -1;
}
fun inputIllegal(inputnum : Array<Int?>) : Int
{
    if (inputnum.size != 3)                                                                     throw IllegalArgumentException("3�ڸ� ���� �ƴմϴ�.");
    inputnum.forEach { 
        if (it !in 1..9)                                                                        throw IllegalArgumentException("1~9 ���� ���� �Է����ּ���.")
    }                      
    if (inputnum[0]==inputnum[1] || inputnum[0]==inputnum[2] || inputnum[1]==inputnum[2])       throw IllegalArgumentException("�ߺ��� �� �Դϴ�.")
    return(0);
}
fun checknum() : Pair<Int, Int>
{
    var ball = 0;
    var strike = 0;
    for (i in 0..3 step(1))
        for (j in 0..3 step(1)) checknum02(i, j)
    return Pair(ball,strike)
}
fun checknum02(i : Int, j :Int) : Pair<Int, Int>
{
    if (comAnswer[i] == inputnum[j]){
        if (i == j) strike++;
        else ball++;
    }
    return Pair(ball,strike)
}
fun print_message() : Int
{
    var doplay : Int = 0

    if (strike == 3)
    {
        println("$strike ��Ʈ����ũ")
        println("3���� ���ڸ� ��� �����̽��ϴ�! ��������")
        println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���")
        doplay = readLine()!!.toInt()
        if (doplay == 2) return (0)
        else playinggame()
    }
    if (strike == 0 && ball > 0 && ball <= 3)
        println("$ball ��")
    if (ball == 0 && strike > 0 && strike <= 3)
        println("$strike ��Ʈ����ũ")
    if (strike == 0 && ball == 0)
        println("����")
    println("$ball �� $strike ��Ʈ����ũ")
    return 1;
}
fun make_answer(comAnswer: Array<Int>) 
{
    val comAnswer : Array<Int?> = arrayOfNulls<Int>(3)
    var switch = BooleanArray(10)
    for (i in switch.indices)
    {
        switch[i] = false 
    }
    var w =0 
    while(w<3)
    {   
        var r = (Math.random() * 10).toInt()
        if(switch[r]==false)
        {
            switch[r] =true 
            comAnswer[w] = r + 1 
            w++
        }
    }
}