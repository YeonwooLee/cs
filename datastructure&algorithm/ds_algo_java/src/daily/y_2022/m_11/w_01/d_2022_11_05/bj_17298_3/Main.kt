package daily.y_2022.m_11.w_01.d_2022_11_05.bj_17298_3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*


val br = BufferedReader(InputStreamReader(System.`in`))
val bw =  BufferedWriter(OutputStreamWriter(System.out))


fun main(){
    val n = br.readLine()!!.toInt()
    val arr = Array<Int>(n){0}
    val result = Array<Int>(n){-1}

    var idx=0
    br.readLine().split(" ").forEach{
        arr[idx++] = it.toInt()
    }

    val s = Stack<Int>()
    s.push(0)

    for(i in 1..n-1){
        while(!s.isEmpty() && arr[s.peek()]<arr[i]){
            result[s.pop()] = arr[i]
        }
        s.push(i)
    }

    result.forEach {
        bw.write("$it ")
    }
    bw.flush()
    bw.close()
}