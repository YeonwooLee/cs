package daily.y_2023.m_02.d_14.swea9229;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와_Spot_Mart {
    static BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());

        for(int tc=0;tc<T;tc++){
            int result = cal();
            System.out.print(String.format("#%d %d\n",tc+1,result));
        }

    }

    static int cal() throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int sum = 0;


        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                sum = arr[i] + arr[j];
                if(sum<=m&& max<sum) max = sum;
            }
        }
        if(max==0)return -1;
        return max;

    }
}
