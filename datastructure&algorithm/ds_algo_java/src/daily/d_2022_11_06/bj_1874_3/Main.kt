package daily.d_2022_11_06.bj_1874_3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*


val br = BufferedReader(InputStreamReader(System.`in`))

fun main(){

    val n = br.readLine().toInt();
    val ans = Array<Int>(n){0}

    for(i in 0..n-1){
        ans[i] = br.readLine().toInt()
    }

    var next = 1 //다음 수
    val stack = Stack<Int>()

    val result = mutableListOf<String>()

    for(i in 0..n-1){
        val find = ans[i]

        if(find>=next){
            while(find>=next){
                stack.push(next++)
                result.add("+")
            }
            stack.pop()
            result.add("-")
        }else{
            if(stack.peek()==find){
                stack.pop()
                result.add("-")
            }else{
                println("NO")
                return
            }
        }
    }

    result.forEach{
        println(it)
    }

}