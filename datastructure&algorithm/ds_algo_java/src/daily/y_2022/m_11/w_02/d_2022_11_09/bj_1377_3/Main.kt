package daily.y_2022.m_11.w_02.d_2022_11_09.bj_1377_3
import algorithms.sort.bubble_sort.bj_1377_3.Node
import java.io.BufferedReader;
import java.io.InputStreamReader;

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array<Node>(n){ Node(0,0) }

    for(i in 0..n-1){
        arr[i].value=br.readLine().toInt()
        arr[i].idx=i
    }

    arr.sort()

    var max = Integer.MIN_VALUE
    var index = 0
    arr.forEach{
        max = maxOf(max,it.idx-index++)
    }
    println(max+1)


}
class Node(var value:Int, var idx:Int) :Comparable<Node>{
    override fun compareTo(other: Node): Int {
        return value-other.value
    }


}