package daily.y_2022.m_11.w_01.d_2022_11_02.swea_3752;


import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[] arr;
    static boolean[] visited;
    static HashSet<Integer> set;

    public static void main(String args[]) throws Exception
    {

        int T;
        T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            init();
            sol(0);
            bw.write("#"+test_case+" "+set.size()+"\n");
        }
        bw.flush();
        bw.close();
    }
    static void sol(int idx){
        if (idx==n) return;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i:set){
            if(!set.contains(i+arr[idx])){
               temp.add(arr[idx]+i);
            }
        }
        for(int i : temp){
            set.add(i);
        }
        sol(idx+1);

    }
    static void init() throws IOException{
        n = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        set.add(0);
        arr= new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}