package daily.d_2022_09_30.bj_11724;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = solution(n,m);
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();

    }

    static int solution(int n, int m) throws IOException{
        int result =0;

        ArrayList<Integer>[] V = new ArrayList[n+1];
        //각 노드 초기화
        for(int i=1;i<=n;i++){
            V[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            V[a].add(b);
            V[b].add(a);
        }

        boolean[] visited = new boolean[n+1];
        for(int i=1;i<V.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i,visited,V);
            result ++;
        }
        return result;
    }
    static void dfs(int v, boolean[] visited,ArrayList<Integer>[] V){
        for(int n:V[v]){
            if(visited[n]) continue;
            visited[n] = true;
            dfs(n,visited,V);
        }
    }
}
