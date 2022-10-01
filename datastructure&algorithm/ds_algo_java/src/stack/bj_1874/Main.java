package stack.bj_1874;
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
        int[] A = new int[N];

        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();

        int num = 1;//스택에 들어갈 다음 수
        boolean result = true;

        for(int i=0;i<A.length;i++){
            int su = A[i];//수열의 수
            if(su>=num){
                while(su>=num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{
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
