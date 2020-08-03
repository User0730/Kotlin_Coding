import sun.font.TrueTypeFont
import java.util.*

open class Object() {
    var hp = 0.0
    var gold = 0.0
}
class char : Object(){
        var atk = 0.0
        var exp = 0.0
}

fun main(){
    var player = char()
    var monster = char()
    inputdata(player, "플레이어")
    inputdata(monster, "몬스터")
}

fun inputdata(name: char, index: String){
    var sc : Scanner = Scanner(System.`in`)
    print("${index} 의 체력 : ")
    var hp = sc.nextDouble()
    name.hp = hp
    print("${index} 의 공격력 : ")
    var atk = sc.nextDouble()
    name.atk = atk
    print("${index} 의 경험치 : ")
    var exp = sc.nextDouble()
    name.exp = exp
    print("${index} 의 잔고 : ")
    var gold = sc.nextDouble()
    name.gold = gold
    println("")
}

fun combat(char1: char, index1: String, char2: char, index2: String){
    println("${index1}가 ${index2}를 공격했다!")
    char2.hp = char2.hp - char1.atk
    if(char1.hp <= 0 || char2.hp <= 0)
        println("전투 종료! \n${index1} 의 체력 : ${char1}, ${index2} 의 체력 : ${char2}")
    else
        println("${index2}의 체력 : ${char2.hp}")

}

fun reward(){

}