package daily.y_2022.m_11.w_04.d_2022_11_22.bj_1967;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int res = Integer.MIN_VALUE;
    static int tempVertexNumber=-1;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());//노드 수
        ArrayList<Node>[] map = new ArrayList[n+1];//0번 거르고 노드 수 만큼 배열 생성
        for(int i=0;i<map.length;i++){//nullPointerException 방지 노드 초기화
            map[i] = new ArrayList<>();
        }
        boolean[] hasChild = new boolean[n+1];

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[s].add(new Node(e,w));
            map[e].add(new Node(s,w));

            hasChild[s] = true;//자식이 있음
        }

        boolean[] visited = new boolean[n+1];
        dfs(1,map,visited,0);


        visited = new boolean[n+1];
        dfs(tempVertexNumber,map,visited,0);
        System.out.println(res);

    }
    static void dfs(int start, ArrayList<Node>[] map, boolean[] visited, int result){
        visited[start] = true;
        if(res<result){
            res = result;
            tempVertexNumber = start;
        }
        for(Node n:map[start]){
            int next = n.vertex;
            int weight = n.weight;
            if(visited[next]) continue;


            dfs(next,map,visited,result+weight);
            visited[next] = false;
        }
    }

    static class Node{
        int vertex;
        int weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}
