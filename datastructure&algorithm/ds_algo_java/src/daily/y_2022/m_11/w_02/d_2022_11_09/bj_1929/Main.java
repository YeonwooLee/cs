package daily.y_2022.m_11.w_02.d_2022_11_09.bj_1929;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] arr = new boolean[n+1];

        primeCheck(arr);
        for(int i=m;i<=n;i++){
            if(!arr[i])System.out.println(i);
        }

    }
    static void primeCheck(boolean[] arr){
        if(arr.length<2) return;
        arr[0]=arr[1]=true;
        for(int i=2; i<=Math.sqrt(arr.length-1);i++){

            if(arr[i]) continue;

            for(int j=i*i;j<=arr.length-1;j+=i){
                arr[j]=true;
            }
        }
    }
}
