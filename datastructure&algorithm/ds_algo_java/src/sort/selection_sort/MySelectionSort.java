package sort.selection_sort;

public class MySelectionSort {
    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int maxIdx=i;
            for(int j=i;j<arr.length;j++){
                if(arr[maxIdx]<arr[j]){
                    maxIdx=j;
                }
            }
            //swap
            swap(arr,i,maxIdx);
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
