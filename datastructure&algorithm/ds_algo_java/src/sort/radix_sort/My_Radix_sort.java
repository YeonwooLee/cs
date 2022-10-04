package sort.radix_sort;

import java.util.PriorityQueue;
import java.util.LinkedList;
import java.io.IOException;
import java.util.Queue;


public class My_Radix_sort {
    public static int[] A;

    public static void main(String[] args) throws IOException {
        A = new int[] {13,24,5346,74};

        //정렬
        Radix_Sort(A, 5);

        //출력
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
    }

    public static void Radix_Sort(int[] A, int max_size) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        Queue<Integer>[] buckets = new LinkedList[10];
        for(int i=0;i<10;i++){
            buckets[i]=new LinkedList<>();
        }

        while (count != max_size) // 최대 자리수 만큼 반복
        {

            for(int i=0;i<A.length;i++){
                int jariNowWatch = A[i]/jarisu; //지금 보고있는 자릿수를 1의자리에 놓은 수
                int nowNum = jariNowWatch%10;//A[i]의 지금 보고있는 자릿수에 있는 수
                buckets[nowNum].offer(A[i]);
            }

            int idx = 0;
            for(int i=0;i<10;i++){
                while(!buckets[i].isEmpty()){
                    int now = buckets[i].poll();
                    output[idx++]=now;
                }
            }


            for (int i = 0; i < A.length; i++) {
                A[i] = output[i]; // 다음 자리 수 이동을 위해 현재 자리수 기준 정렬 데이터 저장
            }
            jarisu = jarisu * 10; // 자리수 증가
            count++;
        }
    }
}