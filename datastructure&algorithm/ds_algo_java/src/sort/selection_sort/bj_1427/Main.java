package sort.selection_sort.bj_1427;
import sort.selection_sort.MySelectionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] temp = br.readLine().toCharArray();

        int[] map = new int[temp.length];
        for(int i=0;i<temp.length;i++){
            map[i] = temp[i]-'0';
        }

        sort(map);

        for(int i=0;i<map.length;i++){
            System.out.print(map[i]);
        }

    }
    public static void sort(int[] arr){
        int maxIdx=0;
        for(int i=0;i<arr.length-1;i++){
            maxIdx=i;
            for(int j=i;j<arr.length;j++){
                if(arr[maxIdx]<arr[j]){
                    maxIdx=j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }
}
