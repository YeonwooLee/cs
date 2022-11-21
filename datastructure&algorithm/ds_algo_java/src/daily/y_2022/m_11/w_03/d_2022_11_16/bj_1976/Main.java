package daily.y_2022.m_11.w_03.d_2022_11_16.bj_1976;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent = new int[201];

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }

        int[][] map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            String[] s = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                if(Integer.parseInt(s[j-1])==1){
                    union(i,j);
                }
            }
        }

        String[] split = br.readLine().split(" ");

        boolean flag=true;
        for(int i=0;i<split.length-1;i++){
            int a = Integer.parseInt(split[i]);
            int b = Integer.parseInt(split[i+1]);

            if(findParent(a)!=findParent(b)){
                flag=false;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static int findParent(int n){
        if(parent[n]==n) return n;
        return parent[n] = findParent(parent[n]);
    }

    static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a<=b) parent[b]=a;
        else parent[a]=b;
    }
}
