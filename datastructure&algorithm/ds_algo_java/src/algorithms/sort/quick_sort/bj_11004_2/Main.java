package algorithms.sort.quick_sort.bj_11004_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
//        int[] arr = { 3, 1, 7, 4, 5, 1, 8, 2,3,3,3,3,3,3,3 };
//        quickSort(arr);
//        for (int bj_12891 : arr) {
//            System.out.println(bj_12891);
//        }
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr);
        System.out.println(arr[K]);

    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        // 더 이상 분할이 되지 않으면 종료
        if (left >= right) return;

        int mid = partition(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid, right);
    }

    // 분할
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        // 엇갈리지 않으면 계속 반복
        while (left <= right) { // 1. 배열에 값이 중복해서 들어가는 경우는 <=

            // left와 right 찾기
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            // 엇갈리지 않으면 swap
            if (left <= right) { // 2. 1과 동일
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}