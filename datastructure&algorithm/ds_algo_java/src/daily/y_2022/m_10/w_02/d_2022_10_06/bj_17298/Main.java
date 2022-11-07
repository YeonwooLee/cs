package daily.y_2022.m_10.w_02.d_2022_10_06.bj_17298;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                result[s.pop()]=arr[i];
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            result[s.pop()] = -1;
        }

        for(int i=0;i<n;i++){
            bw.write(result[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}