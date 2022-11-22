package daily.y_2022.m_11.w_04.d_2022_11_22.bj_16562;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//애들 수
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;//초기 부모 초기화
        }
        int[] cost = new int[N+1];//친구비

        int M = Integer.parseInt(st.nextToken());//친구관계의 수
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            cost[i] = Integer.parseInt(st.nextToken());//i번친구의 친구비
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());//친구1
            int b = Integer.parseInt(st.nextToken());//친구2
            union(a,b,cost);//둘중에 더 싼마이로 그룹화
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<=N;i++){
            set.add(findParent(i));
        }

        int wholeCost = 0;
        for (Integer integer : set) {
            wholeCost+=cost[integer];
        }

        if(wholeCost<=k) System.out.println(wholeCost);
        else System.out.println("Oh no");
    }
    static void union(int a, int b, int[] cost){
        a = findParent(a);
        b = findParent(b);

        if(cost[a]<cost[b]){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    static int findParent(int n){
        if(parent[n]==n) return n;
        parent[n] = findParent(parent[n]);
        return parent[n];
    }
}
