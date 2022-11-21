package daily.y_2022.m_11.w_02.d_2022_11_10.pg_야근_지수_3;

import java.util.PriorityQueue;
import java.util.Comparator;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        //pq에 넣기
        for(int i :works){
            pq.offer(i);
        }
        //n번만큼뺌
        for(int i=0;i<n;i++){
            int num = pq.poll();
            pq.offer(Math.max(0,num-1));
        }

        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }

        return answer;
    }
}