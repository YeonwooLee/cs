package daily.y_2022.m_11.w_01.d_2022_11_03.bj_12891_2
import java.io.BufferedReader;
import java.io.InputStreamReader;

val br = BufferedReader(InputStreamReader(System.`in`))

fun main(){
    val sp = br.readLine().split(" ")
    val s = sp[0].toInt()//총길이
    val p = sp[1].toInt()//창길이

    val arr = br.readLine()!!.toCharArray()//문자열배열

    val countArr = Array<Int>(4){0}//기준배열
    val acgt = br.readLine()!!.split(" ")
    repeat(4){
        countArr[it]=acgt[it].toInt()
    }
    val nowArr = Array<Int>(4){0}//지금세고있는배열

    for(i in 0..p-1){
        addOper(arr[i],nowArr)
    }
    var endPoint = p-1
    var startPoint = 0
    var result = 0
    if(isDNA(countArr,nowArr)) result ++
    while(endPoint<s-1){

        endPoint ++
        startPoint ++
        addOper(arr[endPoint],nowArr)
        removeOper(arr[startPoint-1],nowArr)

        if(isDNA(countArr,nowArr)) result ++
    }
    println(result)

}

fun addOper(c:Char,arr:Array<Int>){
    when(c){
        'A' -> arr[0]++;
        'C' -> arr[1]++;
        'G' -> arr[2]++;
        'T' -> arr[3]++;
    }

}
fun removeOper(c:Char,arr:Array<Int>){
    when(c){
        'A' -> arr[0]--;
        'C' -> arr[1]--;
        'G' -> arr[2]--;
        'T' -> arr[3]--;
    }

}

//dna문자열인지
fun isDNA(gijoon:Array<Int>,arr:Array<Int>):Boolean{
    for(i in 0..arr.size-1){
        if(arr[i]<gijoon[i]) return false
    }
    return true

}