package algorithms.sort.radix_sort.bj_10989_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

const val maxJari = 5
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = IntArray(n){0}

    for(i in 0..n-1){
        arr[i] = br.readLine().toInt()
    }

    radixSort(arr)

    arr.forEach {
        bw.write(it.toString()+"\n")
    }
    bw.flush()
    bw.close()

}

fun radixSort(arr:IntArray){
    val len = arr.size
    val temp = Array<Int>(len){0} //버그시 사이즈 확인 필요

    var count = 0
    var jari = 1

    while(count< maxJari){
        val bucket = IntArray(10){0}

        arr.forEach{
            val jariCurElement = (it/jari)%10 //현재원소 현재자리수
            bucket[jariCurElement]++
        }

        for(i in 1..9){
            bucket[i]+=bucket[i-1]
        }

        for(i in len-1 downTo 0){
            temp[bucket[(arr[i]/jari)%10] - 1] = arr[i]
            bucket[(arr[i]/jari)%10]--
        }

        for(i in 0..len-1){
            arr[i] = temp[i]
        }
        count ++;
        jari*=10
    }


}