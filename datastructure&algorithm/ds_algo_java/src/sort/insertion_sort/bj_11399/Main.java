package sort.insertion_sort.bj_11399;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] map = new int[N];

        for(int i=0;i<N;i++){
            map[i] = sc.nextInt();
        }


        //정렬
        insertionSort(map);
        int cur =0;
        int sum=0;
        for(int i : map){
//            System.out.println(i);
            cur+=i;
            sum+=cur;
        }
        System.out.println(sum);
    }

    static void insertionSort(int[] map){
        for(int i=1;i<map.length;i++){
            int key = map[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(map[j]<=key) break;
                map[j+1]=map[j];
            }
            map[j+1] = key;
        }
    }
}
