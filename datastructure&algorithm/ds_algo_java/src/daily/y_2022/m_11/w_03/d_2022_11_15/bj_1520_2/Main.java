package daily.y_2022.m_11.w_03.d_2022_11_15.bj_1520_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[m+1][n+1];
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                map[i][j] = 0;
                dp[i][j]=-1;
            }
        }
        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        System.out.println(dfs(1,1,map,dp,m,n));
    }

    static int dfs(int sr, int sc, int[][] map, int[][] dp,int m, int n){
        // printArr(dp);
        if(sr==m && sc ==n) return 1;
        if(dp[sr][sc]!=-1) return dp[sr][sc];

        dp[sr][sc] = 0;
        for(int i=0;i<4;i++){
            int nr = sr+dr[i];
            int nc = sc+dc[i];


            if(nr<1||nr>m||nc<1||nc>n) continue;

            if(map[nr][nc]>=map[sr][sc]) continue;


            dp[sr][sc]+=dfs(nr,nc,map,dp,m,n);
        }

        return dp[sr][sc];


    }
    static void printArr(int[][] map){
        System.out.println();
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.printf("%3d ",map[i][j]);
            }
            System.out.println();
        }
    }
}
