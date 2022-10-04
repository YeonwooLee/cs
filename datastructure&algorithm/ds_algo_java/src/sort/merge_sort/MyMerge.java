package sort.merge_sort;

public class MyMerge {
    static int[] temp;
    public static void main(String[] args){
        int[] arr = {3,7,5,6,8,9,3,2};
        temp = new int[arr.length];

        merge_sort(arr,0,arr.length-1);

        for(int i=0;i<temp.length;i++){
            System.out.printf("%2d",temp[i]);
        }
    }
    static void merge_sort(int[] arr,int sI, int eI){
        if(sI>=eI) return;

        int mid = (sI+eI)/2;
        merge_sort(arr,sI,mid);
        merge_sort(arr,mid+1,eI);
        merge(arr,sI,mid,eI);
    }
    static void merge(int[] arr, int sI, int mid, int eI){
        int k = sI;
        int left = sI;
        int right=mid+1;
        while(left<=mid && right<=eI){
            if(arr[left]<arr[right]){
                temp[k]=arr[left];
                left++;
            }else{
                temp[k]=arr[right];
                right++;
            }
            k++;
        }
        if(left<=mid){
            for(int i = left;left<=mid;left++){
                temp[k]=arr[i];
                k++;
            }
        }else{
            for(int i= right;right<=eI;right++){
                temp[k]=arr[i];
                k++;
            }
        }
    }
}
