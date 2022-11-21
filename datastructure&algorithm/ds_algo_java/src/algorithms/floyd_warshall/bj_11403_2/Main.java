package algorithms.floyd_warshall.bj_11403_2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int c=0;c<n;c++){
            for(int s=0;s<n;s++){
                for(int e=0;e<n;e++){
                    if(map[s][c]==1 && map[c][e]==1){
                        map[s][e] =1;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d ",map[i][j]);
            }
            System.out.println();
        }
    }
}
