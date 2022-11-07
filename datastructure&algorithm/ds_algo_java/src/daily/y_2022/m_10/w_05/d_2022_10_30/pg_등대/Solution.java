package daily.y_2022.m_10.w_05.d_2022_10_30.pg_등대;

import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        ArrayList<Integer>[] nodes = new ArrayList[n+1];
        int[] visited = new int[n+1];

        for(int i=1;i<=n;i++){
            nodes[i] = new ArrayList<>();
        }

        for(int[] cur:lighthouse){
            int s = cur[0];
            int e = cur[1];
            nodes[s].add(e);
            nodes[e].add(s);
        }

        dfs(nodes,1,visited);

        int cnt =0;
        for(int i : visited){
            if(i==2) cnt++;
        }
        return cnt;
    }

    static void dfs(ArrayList<Integer>[] nodes, int cur, int[] visited){
        visited[cur] = 1;
        for(int end:nodes[cur]){
            if(visited[end]==0){
                dfs(nodes,end,visited);
                if(visited[end]==1){
                    visited[cur]=2;
                }
            }
        }
    }
}
