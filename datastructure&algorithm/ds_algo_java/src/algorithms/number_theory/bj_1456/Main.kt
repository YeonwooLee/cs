package algorithms.number_theory

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.sqrt

val br = BufferedReader(InputStreamReader(System.`in`))
fun main(){
    val minMax = br.readLine().split(" ");
    val min = minMax[0].toLong();
    val max = minMax[1].toLong();

    //배열 초기화 및 0,1은 소수아님판정
    val arr = Array<Long>(10000001){it.toLong()}
    arr[0] =0
    arr[1] =0

    for (i:Int in 2..sqrt((arr.size-1).toDouble()).toInt()){
        if(arr[i]==0.toLong()) continue
        for(j in i*i until arr.size step(i)){
            arr[j]=0;
        }
    }

    var count = 0

    for(i in 2 until arr.size){
        if(arr[i]!=0.toLong()){
            var temp = arr[i]
            while(arr[i].toDouble()<=max.toDouble()/temp.toDouble()){
                if(arr[i].toDouble()>=min.toDouble()/temp.toDouble()){
                    count++
                }
                temp*=arr[i]
            }
        }
    }

    println(count)



}