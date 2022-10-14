package daily.d_2022_10_14.pg_야근_지수;

import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b.compareTo(a));

        for(int i=0;i<works.length;i++){
            pq.offer(works[i]);
        }


        for(int i=0;i<n;i++){
            int cur = pq.poll();
            // System.out.println(cur);
            if(cur==0) return 0;
            else{
                pq.offer(cur-1);
            }
        }

        long result = 0;
        while(!pq.isEmpty()){
            result+=Math.pow(pq.poll(),2);
        }
        return result;
    }
}