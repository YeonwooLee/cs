package daily.d_2022_10_30.bj_1517_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static long result =0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr;
    static int[] temp;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[arr.length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }



        mergeSort(arr,0,arr.length-1);

        System.out.println(result);




    }
    static void mergeSort(int[] arr, int s, int e){
        if(s>=e) return;
        int mid = s+(e-s)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);


        for(int i=s;i<=e;i++){
            temp[i]=arr[i];
        }

        int idx = s;
        int left = s;
        int right = mid+1;

        while(left<=mid && right<=e){
            if(temp[left]<=temp[right]){
                arr[idx++]=temp[left++];
            }else{
                arr[idx]=temp[right];
                result +=right-idx;
                right++;
                idx++;
            }
        }
        while(left<=mid){
            arr[idx++]=temp[left++];
        }
        while(right<=e){
            arr[idx++]=temp[right++];
        }

    }
}
