package daily.d_2022_10_31.bj_10989_2;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());//배열 길이


        //배열 생성
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxJarisu = 5;
        //정렬
        int[] sorted = radixSort(arr,maxJarisu);
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int[] radixSort(int[] arr,int maxJarisu){
        int len = arr.length;
        int[] result = new int[len];

        int jarisu = 1;//현재 자리수(계산용)
        int count =0;//현재 자리수

        while(count<maxJarisu){//자리수만큼 정렬반복
            //여기서 초기화 해줘야함
            //합배열로 인덱스 구할 때 buckets 예시 1,0,1이 ,1,1,2가 되는데  이게 인덱스 찾아서 넣는 과정을 거쳐도
            //0,1,1밖에 안돼서 0배열로 초기화가 안됨
            int[] buckets = new int[10];
            for(int i=0;i<len;i++){
                int nowJari = (arr[i]/jarisu)%10; //지금 보는 수의 자리
                buckets[nowJari]++;
            }

            //합배열로 인덱스 구할 수 있게
            for(int i=1;i<10;i++){
                buckets[i]+=buckets[i-1];//각 칸에는 인덱스+1이 들어있다
            }

            //인덱스 찾아서 넣는다
            for(int i=len-1;i>=0;i--){
                int nowJari = (arr[i]/jarisu)%10; //지금 보는 수의 자리
                result[buckets[nowJari]-1]=arr[i];
                buckets[nowJari]--;
            }

            for(int i=0;i<len;i++){
                arr[i] = result[i];
            }
            count++;
            jarisu*=10;
        }
        return arr;
    }

}
