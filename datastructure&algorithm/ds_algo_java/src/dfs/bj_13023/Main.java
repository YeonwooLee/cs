package dfs.bj_13023;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean result = false;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //각 사람
        ArrayList<Integer>[] arr = new ArrayList[N];
        for(int i=0;i<N;i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++){
            if(result) break;
            dfs(i,0,arr,visited);
        }

        System.out.println(result?"1":"0");

    }

    static void dfs(int n,int depth,ArrayList[] arr, boolean[] visited){
        if(depth==4||result){
            result = true;
            return;
        }
        visited[n] = true;
        ArrayList<Integer> cur = arr[n];//현재사람
        for(int i : cur){//사람친구순회
            if(visited[i]) continue;
            dfs(i,depth+1,arr,visited);
        }
        visited[n] = false;
    }
}
