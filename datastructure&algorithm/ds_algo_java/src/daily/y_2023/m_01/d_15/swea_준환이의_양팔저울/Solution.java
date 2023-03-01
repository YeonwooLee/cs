package daily.y_2023.m_01.d_15.swea_준환이의_양팔저울;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    static int n;
    // static Scanner sc;
    static int result = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int left, right;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("C:\\Users\\yeonw\\Downloads\\input.txt"));
        // sc = new Scanner(System.in);
        // int testCase = sc.nextInt();


        int testCase = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=testCase;tc++){
            init();
            int[] chus= new int[n];
            boolean[] used= new boolean[n];
            // chus = new int[n];
            // used = new boolean[n];


            String[] temp = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                // chus[i] = sc.nextInt();
                chus[i] = Integer.parseInt(temp[i]);
            }


            dfs(0,chus,used);
            bw.write("#"+tc+" "+result+"\n");
            bw.flush();
            // System.out.println("#"+i+" "+result);
        }

        bw.close();

    }
    static void dfs(int depth,int[] chus, boolean[] used){
        if(depth==chus.length){
            result++;
            return;
        }
        for(int i=0;i<chus.length;i++){
            if(used[i]) continue;//사용한 추

            //왼쪽 올려보기
            used[i]=true;
            int curChu = chus[i];
            left+=curChu;
            dfs(depth+1,chus,used);
            left-=curChu;
            used[i]=false;

            //오른쪽 올려보기
            if(right+curChu>left) continue;
            used[i] = true;
            right+=curChu;
            dfs(depth+1,chus,used);
            right-=curChu;
            used[i] = false;
        }
    }

    static void init() throws IOException{
        result = 0;
        left = 0;
        right = 0;
        n = Integer.parseInt(br.readLine());
        // n = sc.nextInt();

    }
}
