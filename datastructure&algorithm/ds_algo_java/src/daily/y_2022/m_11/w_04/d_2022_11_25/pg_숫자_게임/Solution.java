package daily.y_2022.m_11.w_04.d_2022_11_25.pg_숫자_게임;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int pivot = 0;

        for(int i=0;i<A.length;i++){
            for(int p=pivot;p<B.length;p++){
                pivot++;
                if(B[p]>A[i]){
                    answer++;
                    break;
                }
            }

        }
        return answer;
    }
}