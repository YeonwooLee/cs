package algorithms.DP.bj_2775;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] apt = new int[15][15];
    public static void main(String[] args) throws IOException{
        for(int i=1;i<15;i++){
            apt[i][1]=1;
            apt[0][i]=i;
        }

        for(int i=1;i<15;i++){
            for(int j=2;j<15;j++){
                apt[i][j]=apt[i-1][j]+apt[i][j-1];
            }
        }
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int k =Integer.parseInt(br.readLine());
            int n =Integer.parseInt(br.readLine());
            System.out.println(apt[k][n]);
        }
    }


}
