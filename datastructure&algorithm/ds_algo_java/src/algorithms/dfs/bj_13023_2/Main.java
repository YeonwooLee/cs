package algorithms.dfs.bj_13023_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] map;
    static int n,m;
    static boolean flag = false;

    public static void main(String[] args) throws IOException{
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new ArrayList[n];
        for(int i=0;i<n;i++){
            map[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            String[] se = br.readLine().split(" ");
            int s = Integer.parseInt(se[0]);
            int e = Integer.parseInt(se[1]);
            map[s].add(e);
            map[e].add(s);
        }

        for(int i=0;i<n;i++){
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(i,0,visited);
            if(flag) break;
        }
        System.out.println(flag?1:0);
    }
    static void dfs(int start,int depth,boolean[] visited){
        if(depth==4){//있음
            flag = true;
            return;
        }

        for(int i:map[start]){
            if(visited[i]) continue;

            visited[i] = true;
            dfs(i,depth+1,visited);
            visited[i] = false;
        }


    }

}
