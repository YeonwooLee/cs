package algorithms.sort.quick_sort.bj_11004_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K;
    static int[] arr;

    public static void main(String[] args)throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr);
        System.out.println(arr[K-1]);
    }
    static void quickSort(int[] arr){
        quickSort(arr, 0,arr.length-1);
    }
    static void quickSort(int[] arr, int left, int right){
        if(left>=right) return;
        int mid = partition(arr,left,right);
        quickSort(arr,left,mid-1);
        quickSort(arr,mid,right);


    }

    private static int partition(int[] arr, int left, int right){
        int pivot = arr[(left+right)/2];
        while(left<=right){
            while(arr[left]<pivot) left++;
            while(arr[right]>pivot) right--;

            if(left<=right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;

    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}
