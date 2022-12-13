package daily.y_2022.m_12.d_2022_12_10.pg_등대_2회차;

import java.util.ArrayList;

class Solution {
    static ArrayList<Node>[] map;
    static boolean[] visited;
    static int result = 0;

    public int solution(int n, int[][] lighthouse) {
        map = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1;i<=n;i++){
            map[i]=new ArrayList<>();
        }

        for(int[] con:lighthouse){
            int s = con[0];
            int e = con[1];
            map[s].add(new Node(e,false));
            map[e].add(new Node(s,false));
        }
        visited[1] = true;
        dfs(1);
        return result;

    }
    static int dfs(int num){
        ArrayList<Node> list = map[num];


        boolean flag = false;
        for(Node end:list){
            int endNum = end.num;
            boolean endOn = end.on;
            if(visited[endNum]) continue;

            visited[endNum]= true;
            int isEnd = dfs(endNum);
            if(isEnd ==0) flag = true;//꺼야되는애와 연결되어있으면 켜야된다
        }

        if(flag){
            result++;
            return 1;//불 켜야되는애
        }
        return 0;

    }

    static class Node{
        int num;
        boolean on;

        public Node(int num, boolean on){
            this.num = num;
            this.on = on;
        }
    }
}