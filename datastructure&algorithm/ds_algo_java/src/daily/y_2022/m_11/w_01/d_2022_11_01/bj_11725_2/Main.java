package daily.y_2022.m_11.w_01.d_2022_11_01.bj_11725_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        parent[1]=1;//안해주면 수행시간 n번 추가
        //인접리스트 배열
        ArrayList<Integer>[] map = new ArrayList[n+1];

        //리스트 초기화
        for(int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }

        //맵 생성
        for(int i=1;i<=n-1;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s].add(e);
            map[e].add(s);
        }

        dfs(map,1);

        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }
    }

    static void dfs(ArrayList<Integer>[] map, int v){
        for(int i:map[v]){
            if(parent[i]!=0) continue;
            parent[i]=v;
            dfs(map,i);
        }

    }
}
