package daily.d_2022_10_21.bj_1520;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=-1;
            }
        }


        bw.write(dfs(1,1,m,n,dp,map)+"");
        bw.flush();
        bw.close();
    }

    static int dfs(int sr,int sc,int m,int n,int[][] dp,int[][] map){
        if(sr==m && sc==n) return 1;
        if(dp[sr][sc]!=-1) return dp[sr][sc];

        dp[sr][sc]=0;

        for(int i=0;i<4;i++){
            int nr = sr+dr[i];
            int nc = sc+dc[i];

            if(nr<1||nr>m||nc<1||nc>n) continue;
            if(map[sr][sc]<=map[nr][nc]) continue;

            dp[sr][sc]+=dfs(nr,nc,m,n,dp,map);
        }
        return dp[sr][sc];
    }
}
