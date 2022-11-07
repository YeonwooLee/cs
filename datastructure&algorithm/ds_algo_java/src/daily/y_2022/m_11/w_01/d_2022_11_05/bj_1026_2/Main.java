package daily.y_2022.m_11.w_01.d_2022_11_05.bj_1026_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int S = 0;
        for(int i=0;i<n;i++){
            S += A[i]*getMax(B);
        }

        System.out.println(S);
    }

    static int getMax(int[] B){
        int max = -1;
        int maxIdx = -1;
        for(int i=0;i<B.length;i++){
            if(B[i]>max){
                max = B[i];
                maxIdx = i;
            }
        }

        B[maxIdx] = -1;
        return max;
    }
}

