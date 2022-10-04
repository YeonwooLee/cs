package sort.insertion_sort;

public class My_insertion_sort {
    static void insertion_sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(arr[j]<=key) break;
                arr[j+1]=arr[j];
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,2,5,8,1};
        insertion_sort(arr);


        for(int i=0;i<arr.length;i++){
            System.out.printf("%2d",arr[i]);
        }
    }
}
