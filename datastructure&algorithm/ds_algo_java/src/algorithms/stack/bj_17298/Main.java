package algorithms.stack.bj_17298;
import java.io.*;
import java.util.Stack;



/* 2022-10-01
- 풀이 못떠올림
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());//배열 크기
        int[]A  =new int[n];//수열 배열
        int[]ans = new int[n]; //정답 배열


        //수열 배열 입력
        String[] str = bf.readLine().split(" ");
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(str[i]);
        }


        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);//스택 초기화

        for(int i=1;i<n;i++){
            //스택 안비었음, 현재 수열>스택 top에 들어있는 idx가 가리키는 수열
            int topIdx = myStack.peek();
            //i는 스택에 들어있는 수보다 무조건 크다
            //현재 인덱스인 i보다 인덱스 작은애들 중 값도 작은애들 이면,
            while(!myStack.isEmpty() && A[topIdx]<A[i]){
                ans[myStack.pop()] = A[i];//정답배열에 오큰수를 현재 수열로 저장
            }
            myStack.push(i);
        }

        while(!myStack.isEmpty()){
            ans[myStack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<n;i++){
            bw.write(ans[i]+" ");
        }
        bw.write("\n");
        bw.flush();
    }
}
