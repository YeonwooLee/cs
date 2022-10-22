package daily.d_2022_10_07.bj_1874_2;

import java.util.Scanner;
import java.util.Stack;


/* 2022-10-01
- 비슷하게 풀었는데 수열의 수 대신 스택에 들어갈 수를 기준으로 풀었음
- 출력초과나와서 틀림 - 이유 모름
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //정답수열
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        //계산용스택
        Stack<Integer> stack = new Stack<>();

        //BufferedWriter와 역할 같음
        StringBuffer bf = new StringBuffer();

        int num = 1;//스택에 들어갈 다음 수
        boolean result = true;


        for(int i=0;i<A.length;i++){
            int su = A[i];//지금 필요한 수
            if(su>=num){//필요한 수가 num보다 크거나 같다
                while(su>=num){//stack에 su 들어갈때까지
                    stack.push(num++);//num추가하고 num++
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{//필요한 수가 num보다 작다
                int n = stack.pop();
                if(n!=su){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }

        if(result) System.out.print(bf.toString());
    }

}
