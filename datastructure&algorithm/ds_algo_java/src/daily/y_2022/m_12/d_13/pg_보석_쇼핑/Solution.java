package daily.y_2022.m_12.d_13.pg_보석_쇼핑;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String,Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        int startIdx = 0;
        int min = Integer.MAX_VALUE;

        int nowIdx = 0;
        int[] result = new int[2];
        for(String gem:gems){
            int gemCount = map.getOrDefault(gem,0);
            map.put(gem,gemCount+1);
            q.offer(gem);

            while(true){
                if(map.get(q.peek())>1){
                    map.put(q.peek(),map.get(q.peek())-1);
                    q.poll();
                    startIdx++;
                }else{
                    break;
                }
            }

            if(set.size()==map.size()){
                int curLen = nowIdx-startIdx+1;
                if(curLen<min){
                    min = curLen;
                    result[0] = startIdx+1;
                    result[1] = nowIdx+1;

                }
            }
            nowIdx++;
        }
        return result;
    }

}