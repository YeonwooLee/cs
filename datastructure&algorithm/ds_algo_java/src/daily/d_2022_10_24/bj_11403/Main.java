package daily.d_2022_10_24.bj_11403;

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int c=0;c<n;c++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][c]==1 && map[c][j]==1){
                        map[i][j]=1;
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                bw.write(Integer.toString(map[i][j])+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}