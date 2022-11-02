package daily.d_2022_11_02.swea_3752
import java.io.BufferedReader;
import java.io.BufferedWriter
import java.io.InputStreamReader;
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))


var n:Int = 0
var arr = arrayOf<Int>()
var set:HashSet<Int> = hashSetOf()

fun main(){
    val T = br.readLine().toInt()
    for(test_case in 1..T){
        init()
        check(0)
        bw.write("#"+test_case+" "+set.size.toString()+"\n")
    }
    bw.flush()
    bw.close()
}
fun check(idx:Int){
    if(idx==n) return
    val temp = mutableListOf<Int>()
    for(num in set){
        if(!set.contains(arr[idx]+num)){
            temp.add(arr[idx]+num)
        }
    }
    for(n in temp){
        set.add(n)
    }

    check(idx+1)

}

fun init(){
    n = br.readLine().toInt()
    arr = Array<Int>(n){0}
    var st = br.readLine().split(" ")
    for(i in 0..n-1){
        arr[i] = st[i].toInt()
    }
    set = hashSetOf()
    set.add(0)
}