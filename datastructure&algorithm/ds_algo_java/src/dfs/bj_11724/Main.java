package dfs.bj_11724;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        boolean[] visited = new boolean[N+1];
        ArrayList<Integer>[] map = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            map[i]=new ArrayList<>();
        }


        for(int j=0;j<M;j++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s].add(e);
            map[e].add(s);
        }

        for(int i=1;i<=N;i++){
            if(!visited[i]){
                dfs(map,visited, i);
                result ++;
            }
        }
        System.out.println(result);
    }

    static void dfs(ArrayList<Integer>[] map,boolean[] visited,int n){
        for(int i : map[n]){
            if(!visited[i]){
                visited[i] = true;
                dfs(map,visited,i);
            }
        }
    }
}
