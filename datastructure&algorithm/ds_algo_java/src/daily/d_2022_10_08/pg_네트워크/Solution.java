package daily.d_2022_10_08.pg_네트워크;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            // System.out.println(i+"go!");
            count++;
            dfs(i,visited,computers,n);
        }
        return count;
    }
    static void dfs(int n, boolean[] visited, int[][] computers,int len){
        // System.out.println(n);
        int[] cur = computers[n];
        for(int i=0;i<len;i++){
            if(visited[i]) continue;
            if(cur[i]==0) continue;
            visited[i]=true;
            dfs(i,visited,computers,len);
        }

    }
}