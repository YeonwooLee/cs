package daily.y_2022.m_11.w_04.d_2022_11_22.bj_11004_3

import java.io.BufferedReader
import java.io.InputStreamReader

var br = BufferedReader(InputStreamReader(System.`in`))
fun main(){
    val nk = br.readLine().split(" ")
    val n = nk[0].toInt()
    val k = nk[1].toInt()


    val arr = Array<Int>(n){0}
    val arrValues =  br.readLine().split(" ")
    for(i in 0..n-1){
        arr[i] = arrValues[i].toInt()
    }

    quickSort(arr)
    println(arr[k-1])
}

fun quickSort(arr:Array<Int>){
    quickSort(arr,0,arr.size-1)
}

fun quickSort(arr:Array<Int>, left:Int, right:Int){
    if(left>=right){
        return
    }

    val mid = partition(arr,left,right)
    quickSort(arr,left,mid-1)
    quickSort(arr,mid,right)
}

fun partition(arr:Array<Int>,left:Int,  right:Int):Int{
    val pivot = arr[(left+right)/2]
    var l = left
    var r = right
    while(l<=r){
        while(arr[l]<pivot) l++
        while(arr[r]>pivot) r--
        if(l<=r){
            swap(arr,l,r)
            l++
            r--
        }
    }
    return l
}

fun swap(arr:Array<Int>, a:Int, b:Int){
    val temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp
}