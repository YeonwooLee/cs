package daily.y_2022.m_12.d_2022_12_09.bj_수_정렬하기2_3회차;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] result;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr,0,arr.length-1);

        for(int i=0;i<n;i++){
            // System.out.println(arr[i]);
            bw.write(Integer.toString(arr[i])+"\n");
        }
        bw.flush();
    }
    static void mergeSort(int[] arr, int s, int e){
        if(e<=s) return;

        int mid = s+((e-s)/2);

        //s~m 정렬
        mergeSort(arr, s,mid);
        //m+1~e 정렬
        mergeSort(arr,mid+1,e);
        //s~m, m+1~e 병함
        merge(arr,s,mid,e);
    }

    static void merge(int[] arr, int s, int m, int e){
        int left = s;//s~m
        int right = m+1;//m+1~e
        int now = s;

        while(left<=m && right<=e){
            if(arr[left]<=arr[right]){
                result[now] = arr[left++];
            }else{
                result[now] = arr[right++];
            }
            now++;
        }
        while(left<=m){
            result[now++]=arr[left++];
        }
        while(right<=e){
            result[now++]=arr[right++];
        }

        for(int i=s;i<=e;i++){
            arr[i] = result[i];
        }
    }
}
