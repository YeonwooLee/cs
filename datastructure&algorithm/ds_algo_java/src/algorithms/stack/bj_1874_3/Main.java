package algorithms.stack.bj_1874_3;

import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int ans[];
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());//총 수의 수
        ans = new int[n];//정답배열
        for(int i=0;i<n;i++){
            ans[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;//넣을 수
        Stack<Integer> stack = new Stack<>();

        StringBuffer bf = new StringBuffer();
        for(int i=0;i<n;i++){
            int su = ans[i];//찾는 수

            if(su>=num){//찾는 수가 넣을 수보다 크다
                while(su>=num){
                    stack.push(num++);
                    bf.append("+\n");
                    // bw.write("+\n");
                }
                stack.pop();
                // bw.write("-\n");
                bf.append("-\n");
            }else{//찾는 수가 넣을 수보다 작거나 같다
                if(su==stack.peek()){
                    stack.pop();
                    // bw.write("-\n");
                    bf.append("-\n");
                }else{
                    System.out.println("NO");
                    return;
                }
            }
        }
        // bw.flush();
        // bw.close();
        System.out.print(bf.toString());



    }
}
