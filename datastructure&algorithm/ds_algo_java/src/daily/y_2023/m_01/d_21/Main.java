package daily.y_2023.m_01.d_21;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<input.length;j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = map[0][0];
        for(int i=1; i<n; i++){
            for(int j=0;j<i+1;j++){
                getMax(i,j,map,dp, n);
            }
        }
        int result = 0;
        for(int i=0;i<n;i++){
            result = Math.max(dp[n-1][i],result);
        }
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();

        // printMap(map);
    }
    static void getMax(int r, int c, int[][] map, int[][] dp, int maxRange){
        if(c==maxRange-1){
            dp[r][c] = dp[r-1][c-1]+map[r][c];
        }else if(c-1<0){
            dp[r][c] = dp[r-1][c] + map[r][c];
        }else{
            dp[r][c] = Math.max(dp[r-1][c],dp[r-1][c-1]) + map[r][c];
        }
    }

    static void printMap(int[][] map){
        System.out.println();
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.printf("%d ",map[i][j]);

            }
            System.out.println();
        }
    }
}
