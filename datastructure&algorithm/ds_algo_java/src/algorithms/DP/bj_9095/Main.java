package algorithms.DP.bj_9095;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int t;
    static int[] dp = new int[11];
    public static void main(String[] args) throws IOException{
        t = Integer.parseInt(br.readLine());
        dp[0] =0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        dpCal(4);
        for(int i=0;i<t;i++){
            init();
            bw.write(dp[n]+"\n");
        }
        bw.flush();
        bw.close();
    }
    static void dpCal(int num){
        dp[num]+=dp[num-1];
        dp[num]+=dp[num-2];
        dp[num]+=dp[num-3];
        if(num<10){
            dpCal(num+1);
        }

    }
    static void init() throws IOException{
        n = Integer.parseInt(br.readLine());
    }
}
