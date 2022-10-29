package daily.d_2022_10_29.bj_2751_2_kt

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun mergeSort(list:List<Int>):List<Int>{
    if(list.size<=1) return list

    val mid = list.size/2
    val left = list.subList(0,mid)
    val right = list.subList(mid,list.size)
    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left:List<Int>, right:List<Int>):List<Int>{
    var indexLeft = 0
    var indexRight = 0
    var newList = mutableListOf<Int>()

    while(indexLeft<left.count() && indexRight<right.count()){
        if(left[indexLeft] < right[indexRight]){
            newList.add(left[indexLeft++])
        }else{
            newList.add(right[indexRight++])
        }
    }

    if(indexLeft<left.size){
        while(indexLeft<left.size){
            newList.add(left[indexLeft++])
        }
    }else{
        while(indexRight<right.size){
            newList.add(right[indexRight++])
        }
    }

    return newList


}

fun main(){
    val list = mutableListOf<Int>()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val testCase = br.readLine().toInt()
    for(i in 0 until testCase){
        list.add(br.readLine().toInt())
    }
    for(i in mergeSort(list)){
        println(i)
    }
}