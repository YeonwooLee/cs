package algorithms.DP.bj_1463;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] arr = new int[1000001];
    static boolean flag = false;
    public static void main(String[] args){
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1] = 0;
        arr[2] =1;
        arr[3] = 1;


        for(int i=1;i<arr.length;i++){
            if(i==n){
                System.out.println(arr[i]);
                break;
            }
            dp(i);
            // if(flag) break;
        }

    }
    static void dp(int num){
        int now = arr[num];
        // System.out.println(num+1 + " " + num*2 + " " + num*3 );
        if(num+1<arr.length && arr[num+1]>now+1){
            arr[num+1] = now+1;
        }
        // if(num+1==n){
        //     System.out.println(now+1);
        //     flag = true;
        //     return;
        // }
        if(num*2<arr.length && arr[num*2]>now+1){
            arr[num*2] = now+1;
        }
        // if(num*2==n){
        //     System.out.println(now+1);
        //     flag = true;
        //     return;
        // }
        if(num*3<arr.length && arr[num*3]>now+1){
            arr[num*3] = now+1;
        }
        // if(num*3==n){
        //     System.out.println(now+1);
        //     flag = true;
        //     return;
        // }
    }
}
