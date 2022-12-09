package daily.y_2022.m_12.d_2022_12_09.bj_알고스팟_2회차;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int result = Integer.MAX_VALUE;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    public static void main(String[] args)throws IOException{
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            String curRow = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(curRow.substring(j,j+1));
            }
        }
        boolean[][] visited = new boolean[n][m];

        visited[0][0] = true;
        dfs(map,visited,0,0,0,n,m);
        System.out.println(result);
    }

    static void dfs(int[][] map, boolean[][] visited, int r, int c, int sudo, int n, int m){
        if(sudo>=result) return;
        if(r==n-1 && c==m-1){
            result = Math.min(result,sudo);
            return;
        }

        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0||nr>=n ||nc<0||nc>=m) continue;//범위초과
            if(visited[nr][nc]) continue;//사전방문

            visited[nr][nc] = true;
            if(map[nr][nc]==1){
                dfs(map,visited,nr,nc,sudo+1,n,m);
            }else{
                dfs(map,visited,nr,nc,sudo,n,m);
            }

            visited[nr][nc] = false;
        }

    }
}
