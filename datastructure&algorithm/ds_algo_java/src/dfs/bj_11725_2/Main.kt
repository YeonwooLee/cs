package dfs.bj_11725_2


fun main(){
    val n = readLine()!!.toInt()
    val parent = Array<Int>(n+1){0}
    parent[1]=1//안하면 수행시간 n번 추가
    val arr:Array<MutableList<Int>> = Array<MutableList<Int>>(n+1){ mutableListOf() }

    repeat(n-1){
        val temp = readLine()!!.split(" ")
        val s = temp[0].toInt()
        val e = temp[1].toInt()

        arr[s].add(e)
        arr[e].add(s)
    }

    dfs(arr,parent,1)
    for(i in 2..n){
        println(parent[i])
    }
}

fun dfs(arr:Array<MutableList<Int>>,parent:Array<Int>,v:Int){
    arr[v].forEach{
        if(parent[it]==0){
            parent[it]=v
            dfs(arr,parent,it)
        }
    }
}